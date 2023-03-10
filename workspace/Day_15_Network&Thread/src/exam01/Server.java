package exam01;

import java.net.ServerSocket;
import java.net.Socket;

import thread.ClientThread;

public class Server {
	public static void main(String[] args) {

		ServerSocket server = null;
		try {
			server = new ServerSocket(25600);
		}catch (Exception e) {
			System.out.println("서버를 구동할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("서버를 구동했습니다.");
		while(true) {
			Socket sock = null;
			try {
				sock = server.accept();
				ClientThread ct = new ClientThread(sock);
				ct.start();
			}catch(Exception e) {
				System.out.println(sock.getInetAddress() + "접속 해제" );
			}
		}
		
	}
}
