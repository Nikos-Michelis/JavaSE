import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        try (AsynchronousServerSocketChannel server =
                     AsynchronousServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(1234));
            System.out.println("Server ready!");
            // accept connection
            Future<AsynchronousSocketChannel> futureClient = server.accept();
            // get the connection
            AsynchronousSocketChannel sockClient = futureClient.get();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> futResponse = sockClient.read(buffer);
            int bytes = futResponse.get();
            buffer.flip();
            String response = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("Read " + bytes + " bytes from client (msg: " + response + ")");
            buffer.clear();
            buffer.put(StandardCharsets.UTF_8.encode("Hey Client!!!"));
            buffer.flip();
            futResponse = sockClient.write(buffer);
            bytes = futResponse.get();
            System.out.println("Sent " + bytes + " bytes to client");

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}