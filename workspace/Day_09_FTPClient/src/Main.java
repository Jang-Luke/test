import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import it.sauronsoftware.ftp4j.FTPClient;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String input1;
		int input2 = 0;
		FTPClient client = new FTPClient();

		p2: while(true) {
			System.out.printf("=== FTP Client Program ===\n1. Connect FTP Server\n2. Exit Program\n>>>>");
			input2 = inputInteger();
			if(input2 == 2) {
				try {
					client.disconnect(true);
					System.out.println("FTP Server is disconnected");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else if(input2 != 1) {System.out.println("올바른 숫자를 입력해주세요."); continue;}
			System.out.println("돌아가기 : 0");
			System.out.printf("input url\n>>>>");
			input1 = inputString();
			if(input1.equals("0")) {continue p2;}
			try {
				client.connect(input1,21);
				System.out.println("FTP Server is connected");
			} catch (Exception e) {
				System.out.println("서버에 접속할 수 없습니다.");
				e.printStackTrace();
				continue p2;
			}
			while(true) {
				System.out.println("돌아가기 : 0");
				System.out.printf("Input ID : ");
				String ID = inputString();
				if(ID.equals("0")) {continue p2;}
				System.out.printf("Input PW : ");
				String PW = inputString();
				if(PW.equals("0")) {continue p2;}
				try {
					client.login(ID, PW);
					System.out.println("Login Success!");
					break;
				} catch (Exception e) {
					System.out.println("로그인에 실패했습니다.");
					e.printStackTrace();
					continue;
				}
			}
			p1: while(true) {
				System.out.printf("========== File ==========\n1. Upload File\n2. Download File\n3. Disconnect FTP Server and Exit\n4. Delete File\n>>>>");
				input2 = inputInteger();
				switch(input2) {
				case 1:
					while(true) {
						System.out.println("돌아가기 : 0");
						try {
							System.out.printf("업로드할 파일 경로를 입력해주세요.\n>>>>");
							String uploadLocation = inputString();
							if(uploadLocation.equals("0")) {continue p1;}
							System.out.printf("업로드할 파일 명을 입력해주세요.\n>>>>");
							String uploadFile = inputString();
							if(uploadFile.equals("0")) {continue p1;}
							client.upload(new File(uploadLocation + uploadFile));
							System.out.printf("%s 업로드 완료!\n",uploadFile);
							break;
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
					}
					break;
				case 2:
					try {
						for (String s : client.listNames()) {
							System.out.println(s);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					while(true) {
						System.out.println("돌아가기 : 0");
						try {
							System.out.printf("다운도르 할 파일 명을 입력해주세요.\n>>>>");
							String downloadFile = inputString();
							if(downloadFile.equals("0")) {continue p1;}
							System.out.printf("다운로드할 경로를 입력해주세요.\n>>>>");
							String downloadLocation = inputString();
							if(downloadLocation.equals("0")) {continue p1;}
							client.download(downloadFile, new File(downloadLocation + downloadFile));
							System.out.printf("%s 다운로드 완료!\n",downloadFile);
							break;
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
					}
					break;
				case 3:
					try {
						client.disconnect(true);
						System.out.println("FTP Server is disconnected");
						System.exit(0);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						for (String s : client.listNames()) {
							System.out.println(s);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					while(true) {
						System.out.println("돌아가기 : 0");
						System.out.println("삭제할 파일 명을 입력해주세요.");
						try {
							String delFileName = inputString();
							client.deleteFile(delFileName);
							System.out.printf("%d 파일 삭제 완료!\n",delFileName);
							break;
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
					}
					break;
				default :
					System.out.println("올바른 숫자를 입력해주세요.");
					break;
				}
			}
		}
	}

	static String inputString() {
		String s = null;
		while(true) {
			try {
				s = br.readLine();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return s;
	}
	static int inputInteger() {
		int i = 0;
		while(true) {
			try {
				i = Integer.parseInt(br.readLine());
				break;
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해주세요.");
				e.printStackTrace();
				continue;
			}
		}
		return i;
	}
}
