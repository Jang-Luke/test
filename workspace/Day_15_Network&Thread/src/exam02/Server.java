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
			System.out.println("서버를 구동할 수 없습니다.");
			System.exit(0);
		}
		while(true) {
			Socket sock = null;
			try {
				sock = server.accept();
				System.out.println(sock.getInetAddress() + " 로 부터 연결");
				
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				//클라이언트에 파일전송
				
				
				//하드디스크에서 전송할 파일을 File 객체로 생성
				File root = new File("D:/2023_01_스마트웹/정리메모장/변수및연산자.txt");
				
				//생성된 File 객체에 대하여 InputStream 개방후 DataStream으로 업그레이드
				FileInputStream fis = new FileInputStream(root);
				DataInputStream dis = new DataInputStream(fis);
				//input --> HDD에 있는 파일 가져오기 
				
				
				//HDD에 보관된 파일의 크기만큼 RAM에 공간을 준비
				byte[] fileContents = new byte[(int)root.length()];
				
				//HDD에 보관된 파일의 내용을 RAM에 준비된 공간에 전부 복사
				dis.readFully(fileContents);
				
				
				//로딩 완료된 파일 사이즈를 클라이언트에게 전송
				dos.writeInt((int)root.length()); //length는 long형이라 캐스팅 해주기 
				dos.flush();
				
				//로딩 완료된 파일 내용을 클라이언트에게 전송
				dos.write(fileContents);
				dos.flush();
				
			}catch (Exception e) {
				System.out.println(sock.getInetAddress() + " 접속해제");
			}
		}
	}
}
