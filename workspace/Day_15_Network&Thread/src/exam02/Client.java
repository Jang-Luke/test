package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static DataOutputStream dos;

	public static void main(String[] args) {

		String ip = "192.168.50.65";
		int port = 45000;
		
		try {
			
			Socket client = new Socket(ip,port);

			InputStream is = client.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			OutputStream os = client.getOutputStream();
			Client.dos = new DataOutputStream(os);

			int size = dis.readInt();
			System.out.println(size);
			
			byte[] file = new byte[size];
			
			dis.readFully(file);
			
			File dst = new File("d:/새 폴더/mysong.mp3");
			FileOutputStream fos = new FileOutputStream(dst);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.write(file);
			dos.flush();
			
			fos.close();
					
		}catch(Exception e) {		
			System.out.println("서버에 접속 할 수 없습니다.");

		}
	}
}
