import java.util.Scanner;

public class Test_01 {
	public static void main(String[] args) {
	}

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("���ڿ��� �Է����ּ��� : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�");
				System.exit(0);
			}else {
				System.out.println(str.length() + "���� �Դϴ�.");
			}
		}
	}
}
