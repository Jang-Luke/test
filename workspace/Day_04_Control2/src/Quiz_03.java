import java.util.Scanner;

public class Quiz_03 {  

	public static int validNum(String msg) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
				System.out.println(msg);
				int num = Integer.parseInt(sc.nextLine());
				return num;

			}catch(Exception e) {
				System.out.println("숫자를 입력해야 합니다.");
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = 0;
		int num2 = 0;

		while(true) {
			System.out.println("===계산기 프로그램===");
			System.out.println("연산자 입력(+,-,*,/,Q:나가기) : ");
			String msg = sc.nextLine();

			if(msg.equals("Q")) {
				System.out.println("계산기를 종료합니다."); 
				System.exit(0);
			}
			else if(msg.equals("+") || msg.equals("-") || 
					msg.equals("*") || msg.equals("/")) {
				//이 연산자가 아니면 77번 문장이 출력 되도록 함
			}	

			num1 = validNum("첫 번째 수 : ");
			num2 = validNum("두 번째 수 : ");


			if(msg.equals("+")) {
				int add = (num1 + num2);
				System.out.println("===== 결과 ======");
				System.out.println(num1 + " + " + num2 + " = " +add);
			}
			else if(msg.equals("-")) {
				int minus = (num1 - num2);
				System.out.println("===== 결과 ======");
				System.out.println(num1 + " - " + num2 + " = " +minus);
			}
			else if(msg.equals("*")) {
				int multi = (num1 * num2);
				System.out.println("===== 결과 ======");
				System.out.println(num1 + " * " + num2 + " = " +multi);
			}
			else if(msg.equals("/")) {
				double divi = num1/(double)num2;
				//10/5 >> 10/5.0

				System.out.println("===== 결과 ======");
				System.out.println(num1 + " / " + num2 + " = " + divi);
			}
			else {
				System.out.println("연산자를 다시 입력해주세요.");
			}
		}
	}
}


