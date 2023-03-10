package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {

		String ip = "192.168.50.65";
		int port = 45000;

		try {

			Socket client = new Socket(ip,port);

			InputStream is = client.getInputStream();
			DataInputStream dis = new DataInputStream(is); 
			//서버 들어가서 파일목록 출력

			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
            //서버 들어가서 파일제목 보내기
			
			
			int filesize = dis.readInt();
			System.out.println(filesize);

			for(int i = 0; i<filesize; i++) {
				System.out.println(dis.readUTF());
			}
			
			dos.writeUTF("기밀문서.txt");
			dos.flush();
			
			int size = dis.readInt();
			
			byte[] file = new byte[size];
			
			dis.readFully(file);
			
			File dst = new File("d:/새 폴더/기밀문서.txt");
			
			FileOutputStream fos = new FileOutputStream(dst);
			DataOutputStream dose = new DataOutputStream(fos);
			//
			
			dose.write(file);
			dose.flush();
			
			fos.close();
			
			
		}catch (Exception e) {
			System.out.println("서버에 접속할 수 없습니다.");
		}
	}
}