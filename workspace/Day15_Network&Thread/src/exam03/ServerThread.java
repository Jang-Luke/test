package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket sock;
	public ServerThread(Socket sock) {
		this.sock = sock;
	}
	
	public void run() {
		System.out.println(sock.getInetAddress() + " ���� ���� �Ͼ����ϴ�.");
		try {
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			File root = new File("D:\\2023_01_����Ʈ��\\download");
			File[] fileList = root.listFiles();
			dos.writeInt(fileList.length);
			for (File f : fileList) {
				dos.writeUTF(f.getName());
			}
			String requestedFile = dis.readUTF();
			File target = new File(root+"\\"+requestedFile);
			FileInputStream fis = new FileInputStream(target);
			DataInputStream fdis = new DataInputStream(fis);
			byte[] fileContents = new byte[(int)target.length()];
			dos.writeInt((int)target.length());
			fdis.readFully(fileContents);
			dos.write(fileContents);
			dos.flush();
			dos.close();
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			System.out.println(sock.getInetAddress() + " ���� ���� �����Ͽ����ϴ�.");
		}
	}
}
