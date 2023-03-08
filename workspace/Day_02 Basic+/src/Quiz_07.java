import java.util.Scanner;

public class Quiz_07 {
	

	public static void main(String[] args) {
		// 두 숫자를 입력받아 덧셈한 결과를 출력하는 프로그램을 작성해주세요.
		Scanner in = new Scanner(System.in);
		int a, b;
		int length;
		
		System.out.println("Java 더하기 도구입니다.");
		System.out.println("더해주실 두 숫자를 공백 없이 입력해주세요.");
		System.out.print("A : ");
		a = in.nextInt(); // 첫 번째 숫자 입력
		in.nextLine();
		System.out.print("B : ");
		b = in.nextInt(); // 두 번째 숫자 입력
		in.nextLine();
		System.out.println("======================");
		System.out.print("|   A   :     "+ a);
		length = (int)(Math.log10(a));		// 입력받은 숫자의 개수(자릿수)에 따라 여백의 길이를 조절하는 코드
		for (int i = 6; i > length; i--) {	// *
			System.out.print(" ");			// *
		}									// *
		System.out.println("|");
		System.out.print("|   B   :     "+ b);
		length = (int)(Math.log10(b));
		for (int i = 6; i > length; i--) {
			System.out.print(" ");
		}
		System.out.println("|");
		System.out.println("|--------------------|");
		System.out.print("| A + B =    ["+ (a + b) +"]");
		length = (int)(Math.log10(a+b));
		for (int i = 5; i > length; i--) {
			System.out.print(" ");
		}
		System.out.println("|");
		System.out.println("======================");
	}
}
