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
				System.out.println("���񽺿� ������ �� �����ϴ�.");
				e.printStackTrace();
				continue;
			}

			try {
				System.out.print("input ID: ");
				String id = sc.nextLine();
				System.out.print("input PassWord: ");
				String pass = sc.nextLine();
				client.login(id,pass); 
				System.out.println("�α��� ���� :" + id +" �� ȯ���մϴ�.");
				break;
			}catch(Exception e) {
				System.out.println("�α��ο� �����߽��ϴ�.");
				e.printStackTrace();
			}
			System.out.println("===========File==========");
			System.out.println("1.Download File");
			System.out.println("2.Disconnect FTP Server");
			System.out.println("3.Upload File");
			System.out.print(">>> ");

			int sum = Integer.parseInt(sc.nextLine());

			if(sum == 1) {
				System.out.println("���� ��� �߿� ������.");

				try {
					FTPFile[] names = client.list();
//					String[] names = client.listNames();
					for(int i = 0; i<names.length; i++) {
						System.out.println(names[i].getName()+"\t"+names[i].getSize());
					}

				}catch(Exception e) {
					e.printStackTrace();
				}

				System.out.println("�ٿ�ε��� ������ Ȯ���ڱ��� �Է����ּ���.");
				System.out.println("����.text");

				try {
                                                   //�ٿ�ε�!
					System.out.print(">>> ");
					String down1 = sc.nextLine();
					System.out.print(">>> ");
					String down2 = sc.nextLine();
					client.download(down1, new File(down2));
					System.out.println("�ٿ�ε� �����߽��ϴ�.");
					
				}catch(Exception e) {
					e.printStackTrace();
				}

			}
			else if(sum == 2) { //���� ����
				try {
					client.disconnect(true);
					System.out.println("������ �����մϴ�.");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}

		else if (sum == 3) {   //���ε� !
			System.out.println("��θ� �Է����ּ���.");

			try {
				String up1 = sc.nextLine();
				client.upload(new java.io.File(up1));		
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		}
		else if (num == 2) {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(2);
		}
	}
}
}
