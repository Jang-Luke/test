package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {


		// 1. 클라이언트가 서버에 접속한다.
		// 2. 클라이언트가 먼저 +, -, *, (/) 중 하나를 입력하여 서버에 전송한다.
		// 3. 클라이언트가 숫자 하나를 입력하여 서버에 전송한다.
		// 4. 클라이언트가 숫자를 하나 더 입력하여 서버에 전송한다.
		// 5. 서버는 클라이언트가 전송한 데이터들을 전달 받아 두 숫자에 대하여, 
		//	  2번에서 전송된 연산을 처리하고 그 결과를 클라이언트에 반환한다.
		// 6. 클라이언트는 반환된 결과를 화면에 출력한다.
		// 7. 2번부터 6번까지의 과정을 무한히 반복한다.
		// * 모든 입력값은 정상 입력했다는 전제 하에 작성하세요.
		
		Socket client = new Socket("192.168.50.25", 25000);
		System.out.println("서버에 접속하였습니다.");

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		String in;
		int num;
		while(true) {
			System.out.print("연산자를 입력해주세요.(+, -, *)\n>>");
			in = inputString();
			if(in.equals("+")||in.equals("-")||in.equals("*")) {
				dos.writeUTF(in);
				dos.flush();
			} else {continue;}
			System.out.print("첫 번째 숫자를 입력해주세요 : ");
			num = inputNum();
			dos.writeInt(num);
			dos.flush();
			System.out.print("두 번째 숫자를 입력해주세요 : ");
			num = inputNum();
			dos.writeInt(num);
			dos.flush();
			int result = dis.readInt();
			System.out.print("연산 결과는 "+result+" 입니다.\n");
		}
	}
	public static int inputNum() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				return Integer.parseInt(sc.nextLine()); 
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
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
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
	}
}
