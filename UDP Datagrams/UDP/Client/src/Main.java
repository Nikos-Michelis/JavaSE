import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try (DatagramSocket client = new DatagramSocket()) {
            client.setSoTimeout(500);

            DatagramPacket request = new DatagramPacket(
                    new byte[0], 0,
                    InetAddress.getLocalHost(), 12345);
            client.send(request);

            while(true) {
                DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
                try {
                    client.receive(response);
                } catch (SocketTimeoutException e) {
                    System.out.println("Nothing read");
                    continue;
                }
                String message = new String(response.getData(), StandardCharsets.UTF_8);
                System.out.println("received: " + message.replace("\u0000",""));
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}