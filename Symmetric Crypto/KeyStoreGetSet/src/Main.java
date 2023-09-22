import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.Base64;

public class Main
{
    public static void main(String[] args) throws KeyStoreException {
        // create a secretKey with AES encoder
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("SecretKey: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        /* 1. Store a new key to the keyStore */
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        // wrap the secretKey and prepare the entry and the password
        KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(secretKey);
        // create a password for specific secretKey
        KeyStore.PasswordProtection password = new KeyStore.PasswordProtection("passwordForSecretKey".toCharArray());
        //store it to the KeyStore object (namely in ram memory)
        keyStore.setEntry("nameForSecretKey", entry, password);//parameters for method (setEntry()) nameForSecretKey, secretKey, password for secretKey
        // Save the keyStore to file keys.ks
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
        /* 2. Load the key from keyStore */
        // Load the key from KeyStore with DefaultType (java support)
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        // create an InputStream for file "keys.ks"
        try(InputStream fis = new FileInputStream("keys.ks")) {
            // load the "keys.ks" with password passwordForSecretKey
            keyStore.load(fis, "KeyStorePassword".toCharArray());
            // get the SecretKey and save them to entry
            entry = (KeyStore.SecretKeyEntry) keyStore.getEntry("nameForSecretKey", password);
            // save the entry to secretKey
            secretKey = entry.getSecretKey();
            System.out.println("SecretKey: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        } catch (IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }

    }
}