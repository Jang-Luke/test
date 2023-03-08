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
		System.out.println("서버가 가동되었습니다.");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress()+"님이 접속하였습니다.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		String in;
		int num1, num2;
		while(true) {
			in = dis.readUTF();
			System.out.println("전달 받은 연산자 : "+in);
			num1 = dis.readInt();
			System.out.println("전달 받은 첫 번째 숫자 : "+num1);
			num2 = dis.readInt();
			System.out.println("전달 받은 두 번째 숫자 : "+num2);
			if(in.equals("+")) {
				int result = num1+num2;
				dos.writeUTF("연산결과 : "+result);
				dos.flush();
			} else if(in.equals("-")) {
				int result = num1-num2;
				dos.writeUTF("연산결과 : "+result);
				dos.flush();
			} else if(in.equals("*")) {
				int result = num1*num2;
				dos.writeUTF("연산결과 : "+result);
				dos.flush();
			} 
			
		}
	}
}
