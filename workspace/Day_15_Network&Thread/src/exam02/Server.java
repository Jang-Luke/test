package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
		while(true) {
			Socket sock = null;
			try {
				sock = server.accept();
				System.out.println(sock.getInetAddress() + " �� ���� ����");
				
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				//Ŭ���̾�Ʈ�� ��������
				
				
				//�ϵ��ũ���� ������ ������ File ��ü�� ����
				File root = new File("D:/2023_01_����Ʈ��/�����޸���/�����׿�����.txt");
				
				//������ File ��ü�� ���Ͽ� InputStream ������ DataStream���� ���׷��̵�
				FileInputStream fis = new FileInputStream(root);
				DataInputStream dis = new DataInputStream(fis);
				//input --> HDD�� �ִ� ���� �������� 
				
				
				//HDD�� ������ ������ ũ�⸸ŭ RAM�� ������ �غ�
				byte[] fileContents = new byte[(int)root.length()];
				
				//HDD�� ������ ������ ������ RAM�� �غ�� ������ ���� ����
				dis.readFully(fileContents);
				
				
				//�ε� �Ϸ�� ���� ����� Ŭ���̾�Ʈ���� ����
				dos.writeInt((int)root.length()); //length�� long���̶� ĳ���� ���ֱ� 
				dos.flush();
				
				//�ε� �Ϸ�� ���� ������ Ŭ���̾�Ʈ���� ����
				dos.write(fileContents);
				dos.flush();
				
			}catch (Exception e) {
				System.out.println(sock.getInetAddress() + " ��������");
			}
		}
	}
}
