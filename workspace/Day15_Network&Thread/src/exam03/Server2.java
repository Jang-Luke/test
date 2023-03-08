package exam03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(50000);
			System.out.println("서버 구동 완료");
		} catch (Exception e) {
			System.out.println("서버 구축 실패");
		}
		while(true) {
			Socket sock = null;
			try {
				sock = server.accept();
				ServerThread st = new ServerThread(sock);
				st.start();
			} catch (Exception e) {
				System.out.println("서버 구축 실패");
			}
		}
	}
}
