import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();

		while(true) {
		System.out.println("===FTP Client Program===");
		System.out.println("1.Connect FTP Server");
		System.out.println("2.Exit Program");
		System.out.print(">>> ");
		int num = Integer.parseInt(sc.nextLine());

		if(num == 1) {
			System.out.println("input url");
			System.out.print(">>>");

			String url = sc.nextLine();

			try {
				client.connect(url,21); 
			}catch(Exception e){
				System.out.println("서비스에 접속할 수 없습니다.");
				e.printStackTrace();
				continue;
			}

			try {
				System.out.print("input ID: ");
				String id = sc.nextLine();
				System.out.print("input PassWord: ");
				String pass = sc.nextLine();
				client.login(id,pass); 
				System.out.println("로그인 성공 :" + id +" 님 환영합니다.");
				break;
			}catch(Exception e) {
				System.out.println("로그인에 실패했습니다.");
				e.printStackTrace();
			}
			System.out.println("===========File==========");
			System.out.println("1.Download File");
			System.out.println("2.Disconnect FTP Server");
			System.out.println("3.Upload File");
			System.out.print(">>> ");

			int sum = Integer.parseInt(sc.nextLine());

			if(sum == 1) {
				System.out.println("다음 목록 중에 고르세요.");

				try {
					FTPFile[] names = client.list();
//					String[] names = client.listNames();
					for(int i = 0; i<names.length; i++) {
						System.out.println(names[i].getName()+"\t"+names[i].getSize());
					}

				}catch(Exception e) {
					e.printStackTrace();
				}

				System.out.println("다운로드할 파일을 확장자까지 입력해주세요.");
				System.out.println("예시.text");

				try {
                                                   //다운로드!
					System.out.print(">>> ");
					String down1 = sc.nextLine();
					System.out.print(">>> ");
					String down2 = sc.nextLine();
					client.download(down1, new File(down2));
					System.out.println("다운로드 성공했습니다.");
					
				}catch(Exception e) {
					e.printStackTrace();
				}

			}
			else if(sum == 2) { //서버 종료
				try {
					client.disconnect(true);
					System.out.println("서버를 종료합니다.");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}

		else if (sum == 3) {   //업로드 !
			System.out.println("경로를 입력해주세요.");

			try {
				String up1 = sc.nextLine();
				client.upload(new java.io.File(up1));		
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		}
		else if (num == 2) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(2);
		}
	}
}
}
