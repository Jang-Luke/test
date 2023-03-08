package exam03;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("192.168.50.27", 25000);
			System.out.println("서버에 접속하였습니다.");
			ClientThread ct = new ClientThread(client);
			ct.start();
		} catch (Exception e) {
			System.out.println("접속 실패");
		}
	}
}
