import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(1234)) {
            ExecutorService es = Executors.newFixedThreadPool(1000);
            System.out.println("Server ready!");

            while (true) {
                Socket sockClient = server.accept();
                es.execute(() -> {
                    System.out.println("Connection established");
                    try (InputStream inputStream = sockClient.getInputStream();
                         OutputStream outputStream = new FileOutputStream("logs.xml")) {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            try {
                                int len = inputStream.read(buffer);
                                outputStream.write(buffer, 0, len);
                                if (new String(buffer, StandardCharsets.UTF_8).contains("</log>"))
                                    break;
                            }
                            catch(IOException e) {
                                System.out.println(e);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Connection closed");
                });
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}