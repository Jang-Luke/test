package exam03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(1080);
			System.out.println("서버가 구동되었습니다.");
		} catch(Exception e) {
			System.out.println("서버 연결이 끊어졌습니다.");
		}
		while(true) {
			Socket socket = null;
			try {
				socket = server.accept();
				FileThread ft = new FileThread(socket);
				ft.start();
			} catch(Exception e) {
				System.out.println(socket.getInetAddress() + " 님의 연결이 끊어졌습니다.");
			}
			//			catch(Exception e) {
			//				System.out.println(socket.getInetAddress()+" 님의 연결이 끊어졌습니다.");
			//			}
		}
	}
}