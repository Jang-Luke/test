package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class Cleint {

	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("192.168.50.65", 45000);
			System.out.println("������ �����߽��ϴ�.");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			int fileSize = dis.readInt();
			System.out.println(fileSize);
			byte[] fileContents = new byte[fileSize];
			dis.readFully(fileContents);

			File dst = new File("D:\\2023_01_����Ʈ��\\download\\rufy.jpg");
			FileOutputStream fos = new FileOutputStream(dst);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.write(fileContents);
			dos.flush();
			fos.close();
			System.out.println("�ٿ�� �Ϸ�");
		} catch (Exception e) {
			System.out.println("���ӿ� �����Ͽ����ϴ�.");
		}
	}
}
