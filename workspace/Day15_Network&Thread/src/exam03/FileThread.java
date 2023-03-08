package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileThread extends Thread {
	Socket sock;
	public FileThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {

		System.out.println(sock.getInetAddress() + " ���� Ȯ��");
		try {
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			File root = new File("D:\\2023_01_����Ʈ��\\download");
			File[] fileList = root.listFiles();
			System.out.println(1111);
			dos.writeInt(fileList.length);
			for (File f : fileList) {
				dos.writeUTF(f.getName());
				dos.flush();
			}
			System.out.println(2222);
			String requestedFile = dis.readUTF();
			System.out.println(sock.getInetAddress() + " ���� ������ ���� : " + requestedFile);
			File target = new File(root.getAbsoluteFile()+"\\"+requestedFile);
			byte[] fileContents = new byte[(int)target.length()];
			FileInputStream fis = new FileInputStream(target);
			DataInputStream fdis = new DataInputStream(fis);
			fdis.readFully(fileContents);
			dos.writeInt((int)target.length());
			dos.write(fileContents);
			dos.flush();
			System.out.println("���� �Ϸ�");

			//			for (File f : fileList) {
			//				if(f.getName().equals(requestedFile)) {
			//					byte[] tmpFile = new byte[(int)f.length()];
			//					dos.writeInt((int)f.length());
			//					fdis.readFully(tmpFile);
			//					dos.write(tmpFile);
			//				}
			//			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(sock.getInetAddress() + " ���� ����");
		}
	}


}
