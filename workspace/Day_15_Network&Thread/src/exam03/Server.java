package exam03;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		ServerSocket server = null;
		
		try {
			server = new ServerSocket(25600);
			
		}catch (Exception e) {
			System.out.println("������ ������ �� �����ϴ�.");
			System.exit(0);
		}
		System.out.println("������ �����߽��ϴ�.");
		
		while(true) {
			Socket sock = null;
			
			try {
				sock = server.accept();
				FileThread ct = new FileThread(sock);
				ct.start();
				System.out.println(sock.getInetAddress() + " ���� Ȯ��");
			}catch (Exception e) {
				System.out.println(sock.getInetAddress() + " ���� ����");
			}
		}
	}
}
