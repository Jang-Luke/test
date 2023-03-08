package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {


		// 1. Ŭ���̾�Ʈ�� ������ �����Ѵ�.
		// 2. Ŭ���̾�Ʈ�� ���� +, -, *, (/) �� �ϳ��� �Է��Ͽ� ������ �����Ѵ�.
		// 3. Ŭ���̾�Ʈ�� ���� �ϳ��� �Է��Ͽ� ������ �����Ѵ�.
		// 4. Ŭ���̾�Ʈ�� ���ڸ� �ϳ� �� �Է��Ͽ� ������ �����Ѵ�.
		// 5. ������ Ŭ���̾�Ʈ�� ������ �����͵��� ���� �޾� �� ���ڿ� ���Ͽ�, 
		//	  2������ ���۵� ������ ó���ϰ� �� ����� Ŭ���̾�Ʈ�� ��ȯ�Ѵ�.
		// 6. Ŭ���̾�Ʈ�� ��ȯ�� ����� ȭ�鿡 ����Ѵ�.
		// 7. 2������ 6�������� ������ ������ �ݺ��Ѵ�.
		// * ��� �Է°��� ���� �Է��ߴٴ� ���� �Ͽ� �ۼ��ϼ���.
		
		Socket client = new Socket("192.168.50.25", 25000);
		System.out.println("������ �����Ͽ����ϴ�.");

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		String in;
		int num;
		while(true) {
			System.out.print("�����ڸ� �Է����ּ���.(+, -, *)\n>>");
			in = inputString();
			if(in.equals("+")||in.equals("-")||in.equals("*")) {
				dos.writeUTF(in);
				dos.flush();
			} else {continue;}
			System.out.print("ù ��° ���ڸ� �Է����ּ��� : ");
			num = inputNum();
			dos.writeInt(num);
			dos.flush();
			System.out.print("�� ��° ���ڸ� �Է����ּ��� : ");
			num = inputNum();
			dos.writeInt(num);
			dos.flush();
			int result = dis.readInt();
			System.out.print("���� ����� "+result+" �Դϴ�.\n");
		}
	}
	public static int inputNum() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				return Integer.parseInt(sc.nextLine()); 
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
	}
	public static String inputString() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				return sc.nextLine(); 
			} catch (Exception e) {
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
		}
	}
}
