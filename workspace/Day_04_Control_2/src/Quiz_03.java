import java.util.Scanner;
//계산기 프로그램
//나눗셈 시 소수점 출력
//q 입력 시 아무것도 출력하지 않고 종료
//연산자에 지정된 값이 아닌 다른 값 입력 시 오류 메세지 출력
public class Quiz_03 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		int num1, num2;
		String in = null;
		while(true) {
			System.out.printf("===계산기 프로그램===\n연산자 입력 (+,-,*,/) [q = 종료] : ");
			in = sc.nextLine();
			if(in.equals("q")) {exit();}
			if(in.equals("+")||in.equals("-")||in.equals("*")||in.equals("/")) {
				num1 = validNum("첫 번째 숫자 : ");
				num2 = validNum("두 번째 숫자 : ");
				if (in.equals("+")) {
					plus(num1,num2);
				} else if (in.equals("-")) {
					minus(num1,num2);
				} else if (in.equals("*")) {
					multiple(num1,num2);
				} else if (in.equals("/")) {
					division(num1,num2);
				}
			} else {
				System.out.println("연산자를 다시 입력해주세요.");
				continue;
			}
		}
	}
	public static void plus(int num1, int num2) {
		int num3 = num1 + num2;
		System.out.printf("======결 과======\n%d + %d = %d\n",num1,num2,num3);
		return;
	}
	public static void minus(int num1, int num2) {
		int num3 = num1 - num2;
		System.out.printf("======결 과======\n%d - %d = %d\n",num1,num2,num3);
		return;
	}
	public static void multiple(int num1, int num2) {
		int num3 = num1 * num2;
		System.out.printf("======결 과======\n%d * %d = %d\n",num1,num2,num3);
		return;
	}
	public static void division(double num1, double num2) {
		double num3 = num1 / num2;
		if(num1 % num2 != 0) {
			System.out.printf("======결 과======\n%.0f / %.0f = %.2f\n",num1,num2,num3);
		} else {
			System.out.printf("======결 과======\n%.0f / %.0f = %.0f\n",num1,num2,num3);
		}
		return;
	}
	public static void exit() {
		System.out.println("계산기를 종료합니다.");
		System.exit(0);
	}
	public static int validNum(String s) {
		while(true) {
			try {
				System.out.print(s);
				String a = sc.nextLine(); // a : q 검사용 변수
				if (a.equals("q")) {exit();}
				return Integer.parseInt(a);
			} catch(Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
	}
}

//while(true) {
//	try {
//		System.out.print("첫 번째 숫자 : ");
//		num1 = Integer.parseInt(sc.nextLine());
//		break;
//	} catch(Exception e) {
//		System.out.println("숫자를 입력해주세요.");
//	}
//}
//while(true) {
//	try {
//		System.out.print("두 번째 숫자 : ");
//		num2 = Integer.parseInt(sc.nextLine());
//		break; // 수가 정상 입력 될 시 무한루프 탈출
//	} catch(Exception e) {
//		System.out.println("숫자를 입력해주세요.");
//	}
//}