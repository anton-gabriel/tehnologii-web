package client;

import server.Server;
import utils.dialogs.Dialogs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;
    private Socket socket = null;

    public Client() {
        try {
            socket = new Socket("localhost", Server.PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        Dialogs dialogs = new Dialogs();


    }
}
