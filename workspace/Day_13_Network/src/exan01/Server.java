package exan01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class DosS extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				Server.dos.writeUTF(JOptionPane.showInputDialog("���濡�� ���� �޼���"));
				Server.dos.flush();
			} catch(Exception e) {
				break;
			}
		}
	}
}

class DisS extends Thread {
	public void run() {
		while(true) {
			try {
				String msg = Server.dis.readUTF();
//				JOptionPane.showConfirmDialog(null, msg);
				System.out.println("������ ���� �޼��� : " + msg);
			} catch (Exception e) {
				break;
			}
		}
	}
}

public class Server {
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static void main(String[] args) throws Exception {
		// ���� ����, ��Ʈ ��ȣ�� �Ű������� ����
		ServerSocket server = new ServerSocket(25000);
		// ServerSocket �ν��Ͻ��� ��ī�带 �ֽ��ϱ� ������
		//25000�� ��Ʈ�� �����Ͱ� ������ �˻� �� �㰡
		//���� ���� ���ٰ� 25000 ��Ʈ�� ������ ������ �㰡 �� break;
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress() + " �� ���� ����");

		OutputStream os = socket.getOutputStream();
		Server.dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		Server.dis = new DataInputStream(is);
		new DisS().start();
		new DosS().start();

//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			try {
//				Server.dos.writeUTF(JOptionPane.showInputDialog("���濡�� ���� �޼���"));
//				Server.dos.flush();
//			} catch(Exception e) {
//				break;
//			}
//		}
		//		while(true) { // ������ Ŭ���̾�Ʈ ���̿��� ���� ������ �������� Ÿ�԰� ���� Ƚ�� ���� ���ߴ� ���� '���������� �����' �� �Ѵ�. 
		//			String msg = JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���");
		//			dos.writeUTF(msg);
		//			dos.flush();
		//			
		//			String msg1 = dis.readUTF();
		//			JOptionPane.showMessageDialog(null, msg1);
		//		}
	}
}
