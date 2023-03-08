import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/*
		System.out.print("숫자 입력 : ");
		String str = in.nextLine();
		
		int strToNum = Integer.parseInt(str); // (입력값) 을 숫자로 분석하는 명령어. 문자열로 입력받은 숫자를 integer 형으로 변환해준다.
		
		System.out.println(strToNum + 10);
		str = null;
		*/
		int str2 = 0;
		String str3 = null;
		System.out.print("숫자 입력 : ");
		str2 = in.nextInt();
		in.nextLine();
		System.out.print("문자열 입력 : ");
		str3 = in.nextLine();
		
		System.out.println(str2);
		System.out.println(str3);
		
		
		
	}
}