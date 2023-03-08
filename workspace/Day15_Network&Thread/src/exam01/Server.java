package exam01;

import java.net.ServerSocket;
import java.net.Socket;

import thread.ClientThread;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
		server = new ServerSocket(35000);
		} catch (Exception e) {
			System.out.println("연결에 실패하였습니다.");
		}
		while(true) {
			Socket socket = null;
			try {
				socket = server.accept();
				System.out.println(socket.getInetAddress() + " 님이 접속하였습니다.");
				ClientThread ct = new ClientThread(socket);
				ct.start();
				server.close();
			} catch (Exception e) {
				System.out.println("연결에 실패하였습니다.");
			}
		}
	}
}
