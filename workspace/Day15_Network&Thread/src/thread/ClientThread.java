package thread;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket client;

	public ClientThread(Socket socket) {
		this.client = socket;
	}
	public void run() {
		try {
			InputStream is = client.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				String msg = dis.readUTF();
				System.out.println(msg);
			}
		} catch (Exception e) {
			System.out.println(client.getInetAddress() + " ���� ������ �����Ǿ����ϴ�.");
			return;
		}
	}
}
