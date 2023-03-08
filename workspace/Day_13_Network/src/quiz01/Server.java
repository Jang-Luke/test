package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(25000);
		System.out.println("������ �����Ǿ����ϴ�.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"���� �����Ͽ����ϴ�.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		String in;
		int num1, num2;
		while(true) {
			in = dis.readUTF();
			System.out.println("���� ���� ������ : "+in);
			num1 = dis.readInt();
			System.out.println("���� ���� ù ��° ���� : "+num1);
			num2 = dis.readInt();
			System.out.println("���� ���� �� ��° ���� : "+num2);
			if(in.equals("+")) {
				int result = num1+num2;
				dos.writeUTF("������ : "+result);
				dos.flush();
			} else if(in.equals("-")) {
				int result = num1-num2;
				dos.writeUTF("������ : "+result);
				dos.flush();
			} else if(in.equals("*")) {
				int result = num1*num2;
				dos.writeUTF("������ : "+result);
				dos.flush();
			} 
			
		}
	}
}
