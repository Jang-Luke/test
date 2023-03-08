import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Texe_01 {
	public static void main(String[] args) {

		FTPClient client = new FTPClient();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("<< FTPClient Program >>");
			System.out.println("1. Connect ");
			System.out.println("2. Exit");
			System.out.print(">> ");
			String menu = sc.nextLine();
			if(menu.equals("1")) {
				System.out.print("IP 주소 : "); // 192.168.50.65 // 포트는 21번이라는 전제
				String ip = sc.nextLine();

				// 접속 로직
				try {
					client.connect(ip, 21);
				}catch(Exception e) {
					e.printStackTrace();
					continue; //예외 생기면 넘어갈 수 있게 !
				}

				// 로그인 로직
				while(true) {
					System.out.print("아이디 입력 : ");
					String id = sc.nextLine();

					System.out.print("패스워드 입력 : ");
					String pw = sc.nextLine();

					try {
						client.login(id, pw);
						System.out.println("로그인 성공 : " + id +" 님 환영합니다.");
						break; // 로그인 되면 넘어갈 수 있게 !!
					}catch(Exception e) {
						e.printStackTrace();
					}
				}

				while(true) {
					System.out.println("1. Upload");
					System.out.println("2. Download");
					System.out.println("3. Disconnect");
					System.out.print(">> ");
					String subMenu = sc.nextLine();

					if(subMenu.equals("1")) {

						while(true) {
							System.out.print("업로드 할 파일의 경로 및 이름 (D:/download/exam.txt) : ");
							String fileName = sc.nextLine();
							try {
								client.upload(new File(fileName));
								break;
							}catch(Exception e) {
								e.printStackTrace();
							}
						}

					}else if(subMenu.equals("2")) {
						try {

							FTPFile[] files = client.list();

							for(int i = 0;i < files.length;i++) {
								System.out.println(files[i].getName() +"\t"+files[i].getSize());
							}

							//                     String[] fileNames = client.listNames();
							//
							//                     System.out.println("<< 파일 목록 >> ");
							//                     for(int i = 0;i < fileNames.length;i++) {
							//                        System.out.println(fileNames[i]);
							//                     }

						}catch(Exception e) {
							e.printStackTrace();
							System.out.println("파일 목록을 불러올 수 없습니다.");
							continue;
						}

						while(true) {
							try {
								System.out.print("다운 받을 파일 이름 : ");
								String fileName = sc.nextLine();

								System.out.print("다운 받을 위치 (D:/download/exam.txt) : ");
								String dest = sc.nextLine();

								client.download(fileName, new File(dest));
								break;
							}catch(Exception e) {
								e.printStackTrace();
								System.out.println("파일 다운로드 실패");
							}
						}
					}else if(subMenu.equals("3")) {
						System.out.println("접속 해제");
						try {
							client.disconnect(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					}else {
						System.out.println("메뉴를 다시 확인하세요.");
					}
				}





			}else if(menu.equals("2")) {
				System.out.println("FTPClient 를 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}


	}
}