package thread;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket sock;

	public ClientThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		try {
			System.out.println(sock.getInetAddress() + " �� ���� ����");
			DataInputStream dis = new DataInputStream(sock.getInputStream());

			while(true) {
				String msg = dis.readUTF();
				System.out.println(sock.getInetAddress() + " : " + msg);
			}
			
		}catch(Exception e) {
			System.out.println(sock.getInetAddress() + " ���� ����");
		}
	}

}
