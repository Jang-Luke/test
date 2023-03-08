package exam01;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ReadThread extends Thread {
	public void run() {
		while(true) {
			try {
				String msg = Server.dis.readUTF();
				System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg);
			}catch (Exception e) {
				break;
			}
		}
	}
}
public class Server {

	public static DataInputStream dis;

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(16666);
		//���ϴ� ���� ��ȣ �Է�, wellkhown(0 ~ 1024)�� ���� ����

		Socket socket = server.accept();
		//server soket�� �� ��ǻ���� ramī�� �ֽ��ϱ� ����
		//��, ��� �����͸� �˻��ϱ� �����Ѵ�.
		//���ο� while(true){}�� ���鼭 client�� �������� ramī�� �ֽ� 
		//-> ���� ������
		System.out.println(socket.getInetAddress() + " �� ���� ����");

		//Server -> client
		OutputStream os = socket.getOutputStream();
		//Stream upgrade
		DataOutputStream dos = new DataOutputStream(os);

		//����� ��� ���� (client -> Server)
		InputStream is = socket.getInputStream();


		Scanner sc = new Scanner(System.in);
		new ReadThread().start();

		while (true) {

			String msg = JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���");
			dos.writeUTF(msg); // ��������(���)�� �����
			dos.flush(); // socket���� �޼��� ���۽�ȣ ����


			String msg2 = dis.readUTF();
			JOptionPane.showMessageDialog(null, msg2);
			System.out.println("Ŭ���̾�Ʈ�� ���� �޼���: " + msg2);
		}
	}

}