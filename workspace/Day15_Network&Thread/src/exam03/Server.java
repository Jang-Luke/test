package exam03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(1080);
			System.out.println("������ �����Ǿ����ϴ�.");
		} catch(Exception e) {
			System.out.println("���� ������ ���������ϴ�.");
		}
		while(true) {
			Socket socket = null;
			try {
				socket = server.accept();
				FileThread ft = new FileThread(socket);
				ft.start();
			} catch(Exception e) {
				System.out.println(socket.getInetAddress() + " ���� ������ ���������ϴ�.");
			}
			//			catch(Exception e) {
			//				System.out.println(socket.getInetAddress()+" ���� ������ ���������ϴ�.");
			//			}
		}
	}
}