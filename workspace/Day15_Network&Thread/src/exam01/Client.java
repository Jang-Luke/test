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
		// ���� IP �ּ� : 192.168.50.65
		Socket client = null;
		ClientThread ct = new ClientThread(client);
		try {
			client = new Socket("192.168.50.27", 35000);
		} catch (Exception e) {
			System.out.println("������ ������ �� �����ϴ�.");
		}
		System.out.println("������ ���ӵǾ����ϴ�.");
		while(true) {
			try {
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				System.out.print("������ �޼��� : ");
				dos.writeUTF(br.readLine());
				dos.flush();
			} catch (Exception e) {
				System.out.println("������ �����Ǿ����ϴ�.");
			}
		}
	}
	public static BufferedReader getBR() {
		return br;
	}
}
