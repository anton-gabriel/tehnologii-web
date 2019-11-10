package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {

        Socket s = null;
        ServerSocket ss2 = null;
        System.out.println("Serverul asculta......");
        try {
            ss2 = new ServerSocket(4445);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("eroare pe server");

        }

        while (true) {
            try {
                s = ss2.accept();
                System.out.println("conexiune stabilita");
                ThreadServer st = new ThreadServer(s);
                st.start();

            }

            catch (Exception e) {
                e.printStackTrace();
                System.out.println("eroare la conexiune");

            }
        }
    }
}
