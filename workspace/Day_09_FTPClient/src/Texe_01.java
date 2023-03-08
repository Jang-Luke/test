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
				System.out.print("IP �ּ� : "); // 192.168.50.65 // ��Ʈ�� 21���̶�� ����
				String ip = sc.nextLine();

				// ���� ����
				try {
					client.connect(ip, 21);
				}catch(Exception e) {
					e.printStackTrace();
					continue; //���� ����� �Ѿ �� �ְ� !
				}

				// �α��� ����
				while(true) {
					System.out.print("���̵� �Է� : ");
					String id = sc.nextLine();

					System.out.print("�н����� �Է� : ");
					String pw = sc.nextLine();

					try {
						client.login(id, pw);
						System.out.println("�α��� ���� : " + id +" �� ȯ���մϴ�.");
						break; // �α��� �Ǹ� �Ѿ �� �ְ� !!
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
							System.out.print("���ε� �� ������ ��� �� �̸� (D:/download/exam.txt) : ");
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
							//                     System.out.println("<< ���� ��� >> ");
							//                     for(int i = 0;i < fileNames.length;i++) {
							//                        System.out.println(fileNames[i]);
							//                     }

						}catch(Exception e) {
							e.printStackTrace();
							System.out.println("���� ����� �ҷ��� �� �����ϴ�.");
							continue;
						}

						while(true) {
							try {
								System.out.print("�ٿ� ���� ���� �̸� : ");
								String fileName = sc.nextLine();

								System.out.print("�ٿ� ���� ��ġ (D:/download/exam.txt) : ");
								String dest = sc.nextLine();

								client.download(fileName, new File(dest));
								break;
							}catch(Exception e) {
								e.printStackTrace();
								System.out.println("���� �ٿ�ε� ����");
							}
						}
					}else if(subMenu.equals("3")) {
						System.out.println("���� ����");
						try {
							client.disconnect(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					}else {
						System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
					}
				}





			}else if(menu.equals("2")) {
				System.out.println("FTPClient �� �����մϴ�.");
				System.exit(0);
			}else {
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
			}
		}


	}
}