package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServer extends Thread {

    String data = null;
    Socket socket;


    public ThreadServer(Socket s) {
        this.socket = s;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            data = reader.readLine();

            while (data.compareTo("QUIT") != 0) {
                writer.println("Received: " + data);
                writer.flush();
                System.out.println("Response: " + data);
                data = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("IO Error/ Client " + this.getName() + " terminated abruptly");
        } catch (NullPointerException e) {
            System.out.println("Client " + this.getName() + " closed");
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                    System.out.println("Socket closed.");
                }
            } catch (IOException ie) {
                System.out.println("The socket cannot be closed.");
            }
        }
    }
}