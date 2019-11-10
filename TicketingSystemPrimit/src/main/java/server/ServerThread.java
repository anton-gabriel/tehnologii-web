package server;

import db.ConnectionDB;
import models.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Statement;
import java.util.ArrayList;


public class ServerThread extends Thread {
    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private ServerUtil serverUtil;
    private static User user;

    ServerThread(Socket socket) {
        this.socket = socket;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public void run() {

        String command = null;
        try {
            command = (String) in.readObject();
            System.out.println("aceasta este comdanda: " + command);
            check(command);
        } catch (ClassNotFoundException | IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * check the client command
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void check(String line) throws IOException, ClassNotFoundException {
        if (line.isEmpty() || line == null) {
            System.out.println("bye");
            socket.close();
        }
        if (line.toLowerCase().equalsIgnoreCase("login")) {
            login();
//            System.out.println("Log-in");
        } else if (line.toLowerCase().equalsIgnoreCase("register")) {
            register();

        }
    }

    //
//	/**
//	 * execute register request
//	 * @throws ClassNotFoundException
//	 * @throws IOException
//	 */
    private void register() throws ClassNotFoundException, IOException {
        Statement myState = null;
        String username = (String) in.readObject();
        String password = (String) in.readObject();
        ArrayList<User> userArrayList = new ArrayList<>();
        ConnectionDB myConnectionDB = new ConnectionDB();
        userArrayList = myConnectionDB.getAccounts();
        User utilizator = new User(username, password);
        for (User auxUser : userArrayList) {
            if (!auxUser.getUsername().equals(utilizator.getUsername())) {
                try {
                    myState = ConnectionDB.createConection().createStatement();
                    //corecteaza
                    String sqlInsert = "INSERT INTO users VALUES( 2, ' " + username + "', 'dan', 'client')";
                    out.writeInt(1);
                    myState.executeUpdate(sqlInsert);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(" Userul deja exista! ");
            }

        }
        out.flush();
    }

    //
//	/**
//	 * execute and check login request
//	 * @throws ClassNotFoundException
//	 * @throws IOException
//	 */
    public void login() throws IOException, ClassNotFoundException {
        serverUtil = new ServerUtil();
        String username = (String) in.readObject();
        String password = (String) in.readObject();
        User user = serverUtil.checkLogin(username, password);
        if (user != null && !user.getPassword().isEmpty() && !user.getUsername().isEmpty()) {
            ServerThread.user = new User(user.getUsername(), user.getPassword(), user.getTiputilizator());
            System.out.println(user.toString());
            out.writeObject((user));
            ServerThread.user = user;
            out.writeObject("Login Succesful");
        } else {
            System.out.println("nu e logat");
            out.writeObject("Login Failed");
        }
        out.flush();
    }
}

