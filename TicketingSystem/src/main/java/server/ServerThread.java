package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    String data = null;
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            data = reader.readLine();
            while (data.compareTo("Cancel") != 0) {
                //writer.println("Received: " + data);
                writer.flush();
                data = reader.readLine();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                    System.out.println("Socket closed.");
                }
            } catch (IOException exception) {
                System.out.println("The socket cannot be closed.");
            }
        }
    }
}
