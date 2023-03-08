package quiz03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("192.168.50.14", 25000);
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		int menu;
		String inputS;
		while(true) {
			System.out.printf("=====����ó ���� ���α׷�=====\n1. ����ó �ű� ���\n2. ����ó ��� Ȯ��\n3. �̸����� �˻�\n4. ID�� ����ó ����\n>>>");
			menu = inputInt();
			if (menu < 1 || menu > 4) {System.out.println("�ùٸ� ���ڸ� �Է����ּ���."); continue;}
			dos.writeInt(menu);
			if (menu==1) {
				while(true) {
					System.out.printf("����� ID�� �Է����ּ���.\n>>>");
					dos.writeInt(inputInt()); // ID ����
					if(dis.readInt() == 1) {break;} else {System.out.println("�ߺ��� ID �Դϴ�."); continue;}
				}
				System.out.printf("����� �̸��� �Է����ּ���.\n>>>");
				dos.writeUTF(inputString()); // �̸� ����
				System.out.printf("��ȭ��ȣ�� �Է����ּ���.\n>>>");
				dos.writeUTF(inputString()); // ��ȭ��ȣ ����
				System.out.println(dis.readUTF().equals("ack") ? "����Ϸ�" : "�������");
			} else if (menu == 2) {
				int size = dis.readInt();
				System.out.println("ID\tNamd\tPhone");
				for (int i = 0; i < size; i++) { // array ������ ��ŭ ���� �޾� �ݺ� ��� (id, �̸�, ��ȭ��ȣ)
					System.out.println(dis.readUTF());
				}
			} else if (menu == 3) {
				System.out.printf("ã���� �̸��� �Է����ּ���.\n>>>");
				dos.writeUTF(inputString()); // ������ �˻��� �̸� ����
				int size = dis.readInt(); // �˻� ��� ����, ���������� ������ ��� ��� ���
				System.out.println("ID\tNamd\tPhone");
				for (int i = 0; i < size; i++) { 
					System.out.println(dis.readUTF());
				}
			} else if (menu == 4) {
				System.out.printf("������ ID�� �Է����ּ���.\n>>>");
				dos.writeInt(inputInt()); // ������ ������ ���̵� ����
				System.out.println(dis.readUTF().equals("ack") ? "���� �Ϸ�" : "���� ����");
			}
		}
	}
	public static int inputInt() {
		while(true) {
			try {
				return Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
				continue;
			}
		}
	}
	public static String inputString() {
		while(true) {
			try {
				return br.readLine();
			} catch (Exception e) {
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
				continue;
			}
		}
	}
}
