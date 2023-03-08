package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.50.34",1080);
		}catch(Exception e) {
			System.out.println("서버 접속 오류");
		}
		
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			int index = dis.readInt();
			for(int i = 0 ; i<index ; i++) {
				System.out.println(dis.readUTF());
			}
			
			
		}catch(Exception e) {
			System.out.println(socket.getInetAddress() + " 접속 실패");
		}
		
		
		
	}
}
