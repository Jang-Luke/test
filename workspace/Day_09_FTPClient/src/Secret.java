import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class Secret {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();

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
			}

			while(true) {
			for(int i = 1000; i<10000; i++) {
				
				int num2 = i;
                String num3 = num2+"";
                
			try {
				System.out.print("input ID: ");
				String id = sc.nextLine();
				System.out.print("input PassWord:");
				client.login("java",num3);
			}
			catch(Exception e) {
				System.out.println("�α��ο� �����߽��ϴ�.");
				e.printStackTrace();
				continue;
			}
			}
			}
			
			System.out.println("�α��� ����!");
			System.out.println("===========File==========");
			System.out.println("1.Download File");
			System.out.println("2.Disconnect FTP Server");
			System.out.println("3.Upload File");
			System.out.print(">>> ");

			int sum = Integer.parseInt(sc.nextLine());

			if(sum == 1) {
				System.out.println("���� ��� �߿� ������.");

				try {
					String[] names = client.listNames();
					for(int i = 0; i<names.length; i++) {
						System.out.println(names[i]);
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


