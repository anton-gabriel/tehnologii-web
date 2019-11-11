package server;

import utils.commands.ServerCommand;
import utils.enums.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerThread extends Thread {

    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private ServerCommand serverCommand;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            serverCommand = new ServerCommand(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            Command command;
            do {
                command = (Command) in.readObject();
                this.serverCommand.execute(command);
            } while (command != Command.INVALID);
        } catch (IOException | NullPointerException | ClassNotFoundException exception) {
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
