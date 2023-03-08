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
				System.out.println("���ڸ� �Է��ؾ� �մϴ�.");
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = 0;
		int num2 = 0;

		while(true) {
			System.out.println("===���� ���α׷�===");
			System.out.println("������ �Է�(+,-,*,/,Q:������) : ");
			String msg = sc.nextLine();

			if(msg.equals("Q")) {
				System.out.println("���⸦ �����մϴ�."); 
				System.exit(0);
			}
			else if(msg.equals("+") || msg.equals("-") || 
					msg.equals("*") || msg.equals("/")) {
				//�� �����ڰ� �ƴϸ� 77�� ������ ��� �ǵ��� ��
			}	

			num1 = validNum("ù ��° �� : ");
			num2 = validNum("�� ��° �� : ");


			if(msg.equals("+")) {
				int add = (num1 + num2);
				System.out.println("===== ��� ======");
				System.out.println(num1 + " + " + num2 + " = " +add);
			}
			else if(msg.equals("-")) {
				int minus = (num1 - num2);
				System.out.println("===== ��� ======");
				System.out.println(num1 + " - " + num2 + " = " +minus);
			}
			else if(msg.equals("*")) {
				int multi = (num1 * num2);
				System.out.println("===== ��� ======");
				System.out.println(num1 + " * " + num2 + " = " +multi);
			}
			else if(msg.equals("/")) {
				double divi = num1/(double)num2;
				//10/5 >> 10/5.0

				System.out.println("===== ��� ======");
				System.out.println(num1 + " / " + num2 + " = " + divi);
			}
			else {
				System.out.println("�����ڸ� �ٽ� �Է����ּ���.");
			}
		}
	}
}


