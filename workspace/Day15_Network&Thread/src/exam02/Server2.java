package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

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
				System.out.println(socket.getInetAddress() + " ���� ����Ǿ����ϴ�.");
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				File root = new File("D:\\2023_01_����Ʈ��\\download\\tttt.txt");
				
				FileInputStream fis = new FileInputStream(root);
				DataInputStream fdis = new DataInputStream(fis);

				byte[] fileContents = new byte[(int)root.length()];
				fdis.readFully(fileContents);
				System.out.println(111);
				dos.writeInt((int)root.length());
				dos.flush();
				System.out.println(222);
				dos.write(fileContents);
				dos.flush();
				System.out.println(333);

			} catch(Exception e) {
				System.out.println(socket.getInetAddress()+" ���� ������ ���������ϴ�.");
			}
		}
	}
}