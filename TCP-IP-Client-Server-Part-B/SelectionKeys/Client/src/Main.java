import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        try (AsynchronousSocketChannel client =
                     AsynchronousSocketChannel.open()) {
            Thread.sleep(1000);
            Future<Void> checkConn = client.connect(new InetSocketAddress("127.0.0.1", 1234));
            checkConn.get();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // write
            buffer.put(StandardCharsets.UTF_8.encode("Hey Server!"));
            buffer.flip();
            Future<Integer> futResponse = client.write(buffer);
            int bytes = futResponse.get();
            System.out.println("Sent " + bytes + " bytes to server");
            // read
            buffer.clear();
            futResponse = client.read(buffer);
            bytes = futResponse.get();
            buffer.flip();
            String response = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("Read " + bytes + " bytes from server (msg: " + response + ")");
            // write
            buffer.clear();
            buffer.put(StandardCharsets.UTF_8.encode("quit"));
            buffer.flip();
            futResponse = client.write(buffer);
            bytes = futResponse.get();
            System.out.println("Sent " + bytes + " bytes to server");
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}