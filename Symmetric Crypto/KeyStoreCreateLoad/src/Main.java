import java.io.*;
import java.security.*;
import java.security.cert.*;

public class Main
{

    public static void main(String[] args) throws KeyStoreException {
        // Create a KeyStore (with a password)
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
        // Store to KeyStore
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }
}