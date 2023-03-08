import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class ClientMain {
	public static void main(String[] args) {

		FTPClient client = new FTPClient();
		Scanner sc = new Scanner(System.in);
		Client ct = new Client();
		
		System.out.println("===FTP Client Program===");
		System.out.println("1.Connect FTP Server");
		System.out.println("2.Exit Program");
		System.out.print(">>> ");
		
		ct.setId(sc.nextLine());
		ct.setPassword(sc.nextLine());
		int num = Integer.parseInt(sc.nextLine());
		
	}
	
}
