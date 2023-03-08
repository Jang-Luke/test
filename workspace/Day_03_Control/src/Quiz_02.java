import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b;
		
		System.out.print("첫번째 숫자 입력 : ");
		a = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자 입력 : ");
		b = Integer.parseInt(sc.nextLine());
		System.out.println();
		System.out.println("=======결과=======");
		System.out.println();
		
		if (a < b) {
			System.out.println("두번째 값이 더 크다.");
		} else if (a == b) {
			System.out.println("두 값의 크기가 같다.");
		} else if (a > b) {
			System.out.println("첫번째 값이 더 크다.");
		}
	}

}
