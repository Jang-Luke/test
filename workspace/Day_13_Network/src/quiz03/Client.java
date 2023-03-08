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
			System.out.printf("=====연락처 관리 프로그램=====\n1. 연락처 신규 등록\n2. 연락처 목록 확인\n3. 이름으로 검색\n4. ID로 연락처 삭제\n>>>");
			menu = inputInt();
			if (menu < 1 || menu > 4) {System.out.println("올바른 숫자를 입력해주세요."); continue;}
			dos.writeInt(menu);
			if (menu==1) {
				while(true) {
					System.out.printf("등록할 ID를 입력해주세요.\n>>>");
					dos.writeInt(inputInt()); // ID 전송
					if(dis.readInt() == 1) {break;} else {System.out.println("중복된 ID 입니다."); continue;}
				}
				System.out.printf("등록할 이름을 입력해주세요.\n>>>");
				dos.writeUTF(inputString()); // 이름 전송
				System.out.printf("전화번호를 입력해주세요.\n>>>");
				dos.writeUTF(inputString()); // 전화번호 전송
				System.out.println(dis.readUTF().equals("ack") ? "저장완료" : "저장실패");
			} else if (menu == 2) {
				int size = dis.readInt();
				System.out.println("ID\tNamd\tPhone");
				for (int i = 0; i < size; i++) { // array 사이즈 만큼 수신 받아 반복 출력 (id, 이름, 전화번호)
					System.out.println(dis.readUTF());
				}
			} else if (menu == 3) {
				System.out.printf("찾으실 이름을 입력해주세요.\n>>>");
				dos.writeUTF(inputString()); // 서버로 검색할 이름 전송
				int size = dis.readInt(); // 검색 결과 수신, 동명이인이 존재할 경우 모두 출력
				System.out.println("ID\tNamd\tPhone");
				for (int i = 0; i < size; i++) { 
					System.out.println(dis.readUTF());
				}
			} else if (menu == 4) {
				System.out.printf("삭제할 ID를 입력해주세요.\n>>>");
				dos.writeInt(inputInt()); // 서버로 삭제할 아이디 전송
				System.out.println(dis.readUTF().equals("ack") ? "삭제 완료" : "삭제 실패");
			}
		}
	}
	public static int inputInt() {
		while(true) {
			try {
				return Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해주세요.");
				continue;
			}
		}
	}
	public static String inputString() {
		while(true) {
			try {
				return br.readLine();
			} catch (Exception e) {
				System.out.println("올바른 문자를 입력해주세요.");
				continue;
			}
		}
	}
}
