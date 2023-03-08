package quiz02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Socket client = new Socket("192.168.50.14", 25000);
		System.out.println("������ �����Ͽ����ϴ�.");

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		while(true) {
			while(true) {
				System.out.print("ID�� �Է����ּ��� (1001 ~ 1100) : ");
				dos.writeInt(Integer.parseInt(br.readLine()));
				if(dis.readInt() == 1) {
					dos.writeInt(1);
					break;
				} else {
					dos.writeInt(-1);
					System.out.println("ID�����Դϴ�.");
					continue;
				}
			}
			System.out.print("�̸��� �Է����ּ��� : ");
			dos.writeUTF(br.readLine());
			System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
			dos.writeInt(Integer.parseInt(br.readLine()));

			if(dis.readUTF().equals("ack")) {
				System.out.println("���� �Ϸ�");
			} else {System.out.println("���� ����");}
		}

	}

}
