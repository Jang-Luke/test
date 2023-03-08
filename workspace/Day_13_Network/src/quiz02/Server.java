package quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	public static void main(String[] args) throws Exception {
		// 1. 클라이언트는 서버에 접속한다.
		// 2. 클라이언트는 사람의 고유ID (1001 ~ 1100)를 입력하여 서버에 전송한다.
		// 3. 클라이언트는 사람의 이름을 입력하여 서버에 전송한다.
		// 4. 클라이언트는 사람의 연락처(전화번호)를 입력하여 서버에 전송한다.
		// 5. 서버는 클라이언트로부터 전달된 3가지 데이터를 Contact Instance로 만든다.
		//    Contact [정보은닉 적용] -> id, name, phone 3가지 멤버필드에 대하여
		//    getter/setter/constructor/default constructor 를 가진다.
		// 6. 서버는 만들어진 인스턴스를 데이터 관리 전용 인스턴스인 Manager에게 전달하여 Contact를 저장하는 ArrayList 에 보관한다.
		// 7. 보관을 완료 한 후, 서버는 클라이언트에게 저장 완료의 의미인 ack 를 반환한다.
		// 8. 클라이언트는 ack 가 반환되면, 사용자에게 "저장 완료" 메세지를 출력한다.
		// 9. 2 ~ 8 번 까지의 작업은 무한 반복한다.
		
		ServerSocket server = new ServerSocket(25000);
		System.out.println("서버가 가동되었습니다.");
		Socket socket = server.accept();
		JOptionPane.showMessageDialog(null, socket.getInetAddress() + " 님이 접속하였습니다.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		int id;
		String name;
		String phone;
		
		while(true) {
			while(true) {
				JOptionPane.showMessageDialog(null, "ID 입력");
				id = dis.readInt();
				int check = Manager.getInstance().checkID(id);
				dos.writeInt(check);
				if(check == 1) {break;}
				else {System.out.println("잘못된 ID"); continue;}
			}
			JOptionPane.showMessageDialog(null, "클라이언트로부터 받은 ID : "+id);
//			System.out.println("클라이언트로부터 받은 ID : " + id);
			name = dis.readUTF();
			JOptionPane.showMessageDialog(null, "클라이언트로부터 받은 이름 : " + name);
//			System.out.println("클라이언트로부터 받은 이름 : " + name);
			phone = dis.readUTF();
			JOptionPane.showMessageDialog(null, "클라이언트로부터 받은 전화번호 : " + phone);
//			System.out.println("클라이언트로부터 받은 전화번호 : " + phone);
			Manager.getInstance().addContact(new Contact(id,name,phone));
			dos.writeUTF("ack");
			dos.flush();
			JOptionPane.showMessageDialog(null, "저장된 연락처 "+Manager.getInstance().getSize()+"개");
//			System.out.println("저장된 연락처 "+manager.getSize()+"개");
		}
	}
}