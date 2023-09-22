import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    // encrypt the message with secret key
    public static String encrypt(String text, SecretKey key) throws Exception {
        // get the bytes for message
        byte[] textBytes = text.getBytes();
        // get an instance of the algorithm (take the encryption algorithm )
        Cipher cipher = Cipher.getInstance("AES");
        // init the algorithm for encryption with the key
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // execute the algorithm and take an array with encrypted bytes from message and secret key
        byte[] encryptedBytes = cipher.doFinal(textBytes);
        // convert the encrypted bytes to ASCII text
        // 1. encode to base64
        Base64.Encoder encoderBytesToText = Base64.getEncoder();
        // 2. get an encoded string
        String encryptedText = encoderBytesToText.encodeToString(encryptedBytes);
        // returned the encrypted text
        return encryptedText;
    }
    // Decrypt the message with SecretKey
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        // convert the encryptedText to encryptedBytes (Base64 decode)
        Base64.Decoder decoderTextToBytes = Base64.getDecoder();
        // get decoded bytes from encrypted message
        byte[] encryptedBytes = decoderTextToBytes.decode(encryptedText);
        // get an instance of the algorithm for decryption
        Cipher cipher = Cipher.getInstance("AES");
        // init the algorithm for decryption with the key
        cipher.init(Cipher.DECRYPT_MODE, key);
        // execute the algorithm (return an array with decoded bytes of decrypted message)
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        // convert the decrypted bytes to text
        String decryptedText = new String(decryptedBytes);
        // returned the decrypted text
        return decryptedText;
    }
    // Decode the message and get the secret key
    public static SecretKey getSecretKeyFromBase64String(String secretKeyBase64){
        byte[] decodedKeyBytes = Base64.getDecoder().decode(secretKeyBase64);
        // rebuild key using SecretKeySpec
        return new SecretKeySpec(decodedKeyBytes, 0, decodedKeyBytes.length, "AES");
    }
    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 1234)) {
            Scanner readFromInput = new Scanner(System.in);
            Scanner readFromServer = new Scanner(client.getInputStream(),
                    StandardCharsets.UTF_8);
            PrintWriter writeToServer = new PrintWriter(client.getOutputStream(),
                    true, StandardCharsets.UTF_8);
            System.out.println("Connections is ready!");
            String getSecretKeyFromResponseBase64 = readFromServer.nextLine();
            System.out.println("Encoded Secret Key: " + getSecretKeyFromResponseBase64);
            SecretKey DecodeSecretKey = getSecretKeyFromBase64String(getSecretKeyFromResponseBase64);
            System.out.println("Decode (Decoded from Base64) Secret Key: " + DecodeSecretKey);
            System.out.println("Client ready!");
            while(true) {
                System.out.print("> ");
                String request = readFromInput.nextLine();
                String encryptedRequest = encrypt(request, DecodeSecretKey);
                writeToServer.println(encryptedRequest);
                if (request.equals("quit")) {
                    System.out.println("Bye Bye");
                    break;
                }
                String response = readFromServer.nextLine();
                String decryptedResponse = decrypt(response, DecodeSecretKey);
                System.out.println("Server response: " + response + " [Decrypted as: " + decryptedResponse + "]");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}