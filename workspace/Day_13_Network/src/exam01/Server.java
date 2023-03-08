package exam01;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ReadThread extends Thread {
	public void run() {
		while(true) {
			try {
				String msg = Server.dis.readUTF();
				System.out.println("클라이언트로 부터 메세지 : " + msg);
			}catch (Exception e) {
				break;
			}
		}
	}
}
public class Server {

	public static DataInputStream dis;

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(16666);
		//원하는 소켓 번호 입력, wellkhown(0 ~ 1024)는 쓰지 말기

		Socket socket = server.accept();
		//server soket이 내 컴퓨터의 ram카드 주시하기 시작
		//즉, 통신 데이터를 검사하기 시작한다.
		//내부에 while(true){}가 돌면서 client가 들어오는지 ram카드 주시 
		//-> 무한 실행중
		System.out.println(socket.getInetAddress() + " 로 부터 연결");

		//Server -> client
		OutputStream os = socket.getOutputStream();
		//Stream upgrade
		DataOutputStream dos = new DataOutputStream(os);

		//양방향 통신 설정 (client -> Server)
		InputStream is = socket.getInputStream();


		Scanner sc = new Scanner(System.in);
		new ReadThread().start();

		while (true) {

			String msg = JOptionPane.showInputDialog("클라이언트에게 보낼 메세지");
			dos.writeUTF(msg); // 프로토콜(약속)을 맞춘다
			dos.flush(); // socket으로 메세지 전송신호 송출


			String msg2 = dis.readUTF();
			JOptionPane.showMessageDialog(null, msg2);
			System.out.println("클라이언트가 보낸 메세지: " + msg2);
		}
	}

}