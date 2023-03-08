package exam03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket client;
	
	public ClientThread(Socket sock) {
		this.client = sock;
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			int fileList = dis.readInt();
			System.out.println(fileList);

			for (int i = 0; i < fileList; i++) {
				System.out.println(dis.readUTF());
			}
			System.out.print("�ٿ�ε��� ���� : ");
			String fileName = br.readLine();
			dos.writeUTF(fileName);

			int downFileSize = dis.readInt();

			byte[] downFile = new byte[downFileSize];
			dis.readFully(downFile);
			System.out.print("������ ���� �̸��� �Է����ּ��� : ");
			String fName = br.readLine();
			File dst = new File("D:\\2023_01_����Ʈ��\\downfiletest\\" + fName);
			FileOutputStream fis = new FileOutputStream(dst);
			DataOutputStream fdis = new DataOutputStream(fis);
			//		DataOutputStream fdis = new DataOutputStream(new FileOutputStream(new File("D:\\2023_01_����Ʈ��\\downfiletest\\" + fileName)));
			fdis.write(downFile);
			System.out.println("�ٿ�ε� �Ϸ�!");
		} catch (Exception e) {
			System.out.println("������ ���������ϴ�.");
		}
	}
}
