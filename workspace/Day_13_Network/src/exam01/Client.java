package exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class WriteThread extends Thread {
	public void run() {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				Client.dos.writeUTF(JOptionPane.showInputDialog("서버에게 보낼 메세지"));
				Client.dos.flush();
			}catch (Exception e) {
				break;
			}
		}
	}
}
public class Client {

	public static DataOutputStream dos;

	public static void main(String[] args) throws Exception {

		String ip = "192.168.50.22";
		int port = 18575;

		Socket client = new Socket(ip, port);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		Client.dos = new DataOutputStream(os);

		new WriteThread().start();
		
		while (true) {		
			String msg = dis.readUTF();
			System.out.println(msg);

		}
	}
}