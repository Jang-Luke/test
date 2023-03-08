package exan01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class DosC extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
			System.out.print("상대방에게 보낼 메세지 : ");
			Client.dos.writeUTF(sc.nextLine());
			Client.dos.flush();
			} catch(Exception e) {
				break;
			}
		}
	}
}

class DisC extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
			String msg = Client.dis.readUTF();
			System.out.println("상대방이 보낸 메세지 : " + msg);
			} catch (Exception e) {
				break;
			}
		}
	}
}

public class Client {
	public static DataOutputStream dos;
	public static DataInputStream dis;
	public static void main(String[] args) throws Exception {
		//내 IP : 192.168.50.14
		//강사 IP : 192.168.50.65

		Socket client = new Socket("192.168.50.25",25000);

		InputStream is = client.getInputStream();
		Client.dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		Client.dos = new DataOutputStream(os);

		new DosC().start();
		new DisC().start();
		
//		while(true) {
//			String msg1 = JOptionPane.showInputDialog("서버에게 보낼 메세지");
//			dos.writeUTF(msg1);
//			dos.flush();
//
//			//			String msg = JOptionPane.showInputDialog("서버에게 보낼 메세지");
//			String msg = dis.readUTF();
//			JOptionPane.showMessageDialog(null, msg);
//
//
//			//			JOptionPane.showMessageDialog(null, msg);
//		}
	}
}
