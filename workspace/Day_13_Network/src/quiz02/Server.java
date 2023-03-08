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
		// 1. Ŭ���̾�Ʈ�� ������ �����Ѵ�.
		// 2. Ŭ���̾�Ʈ�� ����� ����ID (1001 ~ 1100)�� �Է��Ͽ� ������ �����Ѵ�.
		// 3. Ŭ���̾�Ʈ�� ����� �̸��� �Է��Ͽ� ������ �����Ѵ�.
		// 4. Ŭ���̾�Ʈ�� ����� ����ó(��ȭ��ȣ)�� �Է��Ͽ� ������ �����Ѵ�.
		// 5. ������ Ŭ���̾�Ʈ�κ��� ���޵� 3���� �����͸� Contact Instance�� �����.
		//    Contact [�������� ����] -> id, name, phone 3���� ����ʵ忡 ���Ͽ�
		//    getter/setter/constructor/default constructor �� ������.
		// 6. ������ ������� �ν��Ͻ��� ������ ���� ���� �ν��Ͻ��� Manager���� �����Ͽ� Contact�� �����ϴ� ArrayList �� �����Ѵ�.
		// 7. ������ �Ϸ� �� ��, ������ Ŭ���̾�Ʈ���� ���� �Ϸ��� �ǹ��� ack �� ��ȯ�Ѵ�.
		// 8. Ŭ���̾�Ʈ�� ack �� ��ȯ�Ǹ�, ����ڿ��� "���� �Ϸ�" �޼����� ����Ѵ�.
		// 9. 2 ~ 8 �� ������ �۾��� ���� �ݺ��Ѵ�.
		
		ServerSocket server = new ServerSocket(25000);
		System.out.println("������ �����Ǿ����ϴ�.");
		Socket socket = server.accept();
		JOptionPane.showMessageDialog(null, socket.getInetAddress() + " ���� �����Ͽ����ϴ�.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		int id;
		String name;
		String phone;
		
		while(true) {
			while(true) {
				JOptionPane.showMessageDialog(null, "ID �Է�");
				id = dis.readInt();
				int check = Manager.getInstance().checkID(id);
				dos.writeInt(check);
				if(check == 1) {break;}
				else {System.out.println("�߸��� ID"); continue;}
			}
			JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�κ��� ���� ID : "+id);
//			System.out.println("Ŭ���̾�Ʈ�κ��� ���� ID : " + id);
			name = dis.readUTF();
			JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�κ��� ���� �̸� : " + name);
//			System.out.println("Ŭ���̾�Ʈ�κ��� ���� �̸� : " + name);
			phone = dis.readUTF();
			JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�κ��� ���� ��ȭ��ȣ : " + phone);
//			System.out.println("Ŭ���̾�Ʈ�κ��� ���� ��ȭ��ȣ : " + phone);
			Manager.getInstance().addContact(new Contact(id,name,phone));
			dos.writeUTF("ack");
			dos.flush();
			JOptionPane.showMessageDialog(null, "����� ����ó "+Manager.getInstance().getSize()+"��");
//			System.out.println("����� ����ó "+manager.getSize()+"��");
		}
	}
}