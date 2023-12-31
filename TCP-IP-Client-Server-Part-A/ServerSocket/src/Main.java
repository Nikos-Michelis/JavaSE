import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// open a server socket in try-with-resources-block and bind to port 1234
        try (ServerSocket server = new ServerSocket(1234)) {
	    // accept() method block until connect some client
            Socket sockClient = server.accept();
            // server input
            Scanner readFromClient = new Scanner(sockClient.getInputStream(),
                    StandardCharsets.UTF_8);
            // server output
            PrintWriter writeToClient = new PrintWriter(sockClient.getOutputStream(),
                    true, StandardCharsets.UTF_8);

            // do something with your client

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}