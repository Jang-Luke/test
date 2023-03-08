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
		System.out.println("서버에 접속하였습니다.");

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		while(true) {
			while(true) {
				System.out.print("ID를 입력해주세요 (1001 ~ 1100) : ");
				dos.writeInt(Integer.parseInt(br.readLine()));
				if(dis.readInt() == 1) {
					dos.writeInt(1);
					break;
				} else {
					dos.writeInt(-1);
					System.out.println("ID오류입니다.");
					continue;
				}
			}
			System.out.print("이름을 입력해주세요 : ");
			dos.writeUTF(br.readLine());
			System.out.print("전화번호를 입력해주세요 : ");
			dos.writeInt(Integer.parseInt(br.readLine()));

			if(dis.readUTF().equals("ack")) {
				System.out.println("저장 완료");
			} else {System.out.println("저장 실패");}
		}

	}

}
