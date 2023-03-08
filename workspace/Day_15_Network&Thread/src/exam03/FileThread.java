package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileThread extends Thread {

	private Socket sock;

	public FileThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		while(true) {		
			try {

				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				DataInputStream dis = new DataInputStream(sock.getInputStream());

				File root = new File("D:/새 폴더");
				File[] fileList = root.listFiles();

				dos.write(fileList.length);  
				dos.flush();
				

				for(File f : fileList) {
					dos.writeUTF(f.getName());
					dos.flush();
				}

				String targetName = dis.readUTF();
				System.out.println(sock.getInetAddress() +  " 님이 선택한 파일 : " + targetName);

				File target = new File(root.getAbsoluteFile() + "/" + targetName);
				DataInputStream fileDis = new DataInputStream(new FileInputStream(target));
				byte[] fileContents = new byte[(int)target.length()];
				fileDis.readFully(fileContents);

				dos.write(fileContents);
				dos.flush();
			}
			catch(Exception e) {
				System.out.println("파일 보내기 실패");
			}
		}
	}
}