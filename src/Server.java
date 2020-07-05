import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        final int PORT = 1889;

        try {
            server = new ServerSocket(PORT);

            System.out.println("Server running.");

            socket = server.accept();
            System.out.println("Client connected.");

            Scanner inText = new Scanner(socket.getInputStream());

            while (true) {
                String inMessage = inText.nextLine();

                System.out.println("Client: " + inMessage);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
