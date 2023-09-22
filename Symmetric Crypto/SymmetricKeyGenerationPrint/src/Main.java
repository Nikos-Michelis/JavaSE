import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.*;

public class Main
{
    public static void main(String[] args)
    {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        SecretKey key = keyGenerator.generateKey();
        System.out.println(key);
        System.out.println("Array with ASCII bytes: " + Arrays.toString(key.getEncoded()));
        System.out.println("Base64 bytes: " + Arrays.toString(Base64.getEncoder().encode(key.getEncoded())));
        // return an encode base64 string
        System.out.println("Base64 String: " + Base64.getEncoder().encodeToString(key.getEncoded()));
    }
}