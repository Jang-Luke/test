package exam03;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("192.168.50.27", 25000);
			System.out.println("������ �����Ͽ����ϴ�.");
			ClientThread ct = new ClientThread(client);
			ct.start();
		} catch (Exception e) {
			System.out.println("���� ����");
		}
	}
}
