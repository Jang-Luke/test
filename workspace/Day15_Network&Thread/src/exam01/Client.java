package exam01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import thread.ClientThread;

public class Client {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		// 강사 IP 주소 : 192.168.50.65
		Socket client = null;
		ClientThread ct = new ClientThread(client);
		try {
			client = new Socket("192.168.50.27", 35000);
		} catch (Exception e) {
			System.out.println("서버에 접속할 수 없습니다.");
		}
		System.out.println("서버에 접속되었습니다.");
		while(true) {
			try {
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				System.out.print("전송할 메세지 : ");
				dos.writeUTF(br.readLine());
				dos.flush();
			} catch (Exception e) {
				System.out.println("접속이 해제되었습니다.");
			}
		}
	}
	public static BufferedReader getBR() {
		return br;
	}
}
