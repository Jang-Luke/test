import java.util.Scanner;

public class Test_01 {
	public static void main(String[] args) {
	}

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}
	}
}
