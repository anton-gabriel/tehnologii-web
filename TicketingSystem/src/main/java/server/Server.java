package server;

import utils.ServerPool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server.
 */
public class Server {
    /**
     * The constant PORT.
     */
    public static final int PORT = 5503;

    /**
     * Start the server.
     *
     * @throws Exception the exception
     */
    public void start() throws Exception {
        new Thread(() -> {
            try {
                System.out.println("Server is up and ready for conections ");
                ServerSocket serverSocket = new ServerSocket(PORT);

                while (true) {
                    Socket socket = serverSocket.accept();
                    new Thread(new ServerThread(socket)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            new Server().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
