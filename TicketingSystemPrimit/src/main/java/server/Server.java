package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 1234;
/**
 * server connection
 */
	public void start () throws Exception {

		new Thread( () -> {
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

	public static void main (String[] args) {

		try {
			new Server().start();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}