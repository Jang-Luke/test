package exam02;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(123456);
			System.out.println("서버를 구동했습니다.");
		} catch(Exception e) {
			System.out.println("서버 구동 실패");
			System.exit(0);
		}
		while(true) {
			Socket socket;
			try {
				socket = server.accept();
				System.out.println(server.getInetAddress() + " 님이 접속했습니다.");
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
//				// 하드 디스크에서 전송할 파일을 File 객체로 생성
//				File root = new File("경로+파일명");
				
//				// 생성된 File 객체에 대하여 InputStream 개방 후 DataStream으로 업그레이드
//				FileInputStream fis = new FileInputStream(root);
//				DataInputStream dis = new DataInputStream(fis);
//				// 램을 기준으로 들어오는 것 = input stream, 나가는 것 = output stream
				
				
//				// HDD에 보관된 파일의 크기만큼 RAM에 공간을 준비
//				byte[] fileContents = new byte[(int)root.length()];
				
//				// HDD에 보관된 파일의 내용을 RAM에 준비한 공간에 전부 복사
//				dis.readFully(fileContents);
				
//				// 로딩 완료된 파일 내용을 클라이언트에게 전송
				
				
				
			} catch(Exception e) {
				System.out.println(server.getInetAddress() + " 님이 접속을 해제했습니다.");
			}
		}
	}
}
