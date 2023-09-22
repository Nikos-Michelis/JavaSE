import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class Main
{

    // stackoverflow: https://stackoverflow.com/questions/29852290/self-signed-x509-certificate-with-bouncy-castle-in-java
    public static Certificate selfSign(KeyPair keyPair, String subjectDN) throws OperatorCreationException, CertificateException, IOException
    {
        Provider bcProvider = new BouncyCastleProvider();
        Security.addProvider(bcProvider);

        long now = System.currentTimeMillis();
        Date startDate = new Date(now);

        X500Name dnName = new X500Name(subjectDN);
        BigInteger certSerialNumber = new BigInteger(Long.toString(now)); // <-- Using the current timestamp as the certificate serial number

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

        Date endDate = calendar.getTime();

        String signatureAlgorithm = "SHA1withRSA"; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

        ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());

        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());

        // Extensions --------------------------

        // Basic Constraints
        BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

        certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

        // -------------------------------------

        return new JcaX509CertificateConverter().setProvider(bcProvider).getCertificate(certBuilder.build(contentSigner));
    }

    public static void main(String[] args) throws KeyStoreException {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("private key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // A. Store a Private Key
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.load(null, null);
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        // Load the KeyStore
        try (InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        // prepare the entry and the password
        Certificate cert = null;
        try {
            String subjectDN = "CN=Jim Psounis," +
                    "SURNAME=Psounis," +
                    "SERIALNUMBER=213243-1234," +
                    "C=SE," +
                    "DC=psounis.com";
            cert = selfSign(keyPair, subjectDN);
        } catch (OperatorCreationException | IOException | CertificateException e) {
            e.printStackTrace();
        }

        KeyStore.PrivateKeyEntry entry = new KeyStore.PrivateKeyEntry(privateKey, new Certificate[] {cert});
        KeyStore.PasswordProtection password =
                new KeyStore.PasswordProtection("passwordForPrivateKey".toCharArray());
        keyStore.setEntry("nameForPrivateKey", entry, password);

        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        /* B. Load the key from keyStore */
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try(InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
            entry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("nameForPrivateKey", password);
            privateKey = entry.getPrivateKey();
            System.out.println("Private Key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        } catch (IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }
    }
}