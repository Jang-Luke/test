package exam02;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(123456);
			System.out.println("������ �����߽��ϴ�.");
		} catch(Exception e) {
			System.out.println("���� ���� ����");
			System.exit(0);
		}
		while(true) {
			Socket socket;
			try {
				socket = server.accept();
				System.out.println(server.getInetAddress() + " ���� �����߽��ϴ�.");
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
//				// �ϵ� ��ũ���� ������ ������ File ��ü�� ����
//				File root = new File("���+���ϸ�");
				
//				// ������ File ��ü�� ���Ͽ� InputStream ���� �� DataStream���� ���׷��̵�
//				FileInputStream fis = new FileInputStream(root);
//				DataInputStream dis = new DataInputStream(fis);
//				// ���� �������� ������ �� = input stream, ������ �� = output stream
				
				
//				// HDD�� ������ ������ ũ�⸸ŭ RAM�� ������ �غ�
//				byte[] fileContents = new byte[(int)root.length()];
				
//				// HDD�� ������ ������ ������ RAM�� �غ��� ������ ���� ����
//				dis.readFully(fileContents);
				
//				// �ε� �Ϸ�� ���� ������ Ŭ���̾�Ʈ���� ����
				
				
				
			} catch(Exception e) {
				System.out.println(server.getInetAddress() + " ���� ������ �����߽��ϴ�.");
			}
		}
	}
}
