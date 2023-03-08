package exan01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class DosS extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				Server.dos.writeUTF(JOptionPane.showInputDialog("상대방에게 보낼 메세지"));
				Server.dos.flush();
			} catch(Exception e) {
				break;
			}
		}
	}
}

class DisS extends Thread {
	public void run() {
		while(true) {
			try {
				String msg = Server.dis.readUTF();
//				JOptionPane.showConfirmDialog(null, msg);
				System.out.println("상대방이 보낸 메세지 : " + msg);
			} catch (Exception e) {
				break;
			}
		}
	}
}

public class Server {
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static void main(String[] args) throws Exception {
		// 소켓 공장, 포트 번호를 매개변수로 전달
		ServerSocket server = new ServerSocket(25000);
		// ServerSocket 인스턴스가 랜카드를 주시하기 시작함
		//25000번 포트에 데이터가 들어오면 검사 후 허가
		//무한 루프 돌다가 25000 포트에 데이터 들어오면 허가 후 break;
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress() + " 로 부터 연결");

		OutputStream os = socket.getOutputStream();
		Server.dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		Server.dis = new DataInputStream(is);
		new DisS().start();
		new DosS().start();

//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			try {
//				Server.dos.writeUTF(JOptionPane.showInputDialog("상대방에게 보낼 메세지"));
//				Server.dos.flush();
//			} catch(Exception e) {
//				break;
//			}
//		}
		//		while(true) { // 서버와 클라이언트 사이에서 서로 전송할 데이터의 타입과 전송 횟수 등을 맞추는 것을 '프로토콜을 맞춘다' 고 한다. 
		//			String msg = JOptionPane.showInputDialog("클라이언트에게 보낼 메세지");
		//			dos.writeUTF(msg);
		//			dos.flush();
		//			
		//			String msg1 = dis.readUTF();
		//			JOptionPane.showMessageDialog(null, msg1);
		//		}
	}
}
