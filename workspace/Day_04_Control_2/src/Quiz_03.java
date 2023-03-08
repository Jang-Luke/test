import java.util.Scanner;
//���� ���α׷�
//������ �� �Ҽ��� ���
//q �Է� �� �ƹ��͵� ������� �ʰ� ����
//�����ڿ� ������ ���� �ƴ� �ٸ� �� �Է� �� ���� �޼��� ���
public class Quiz_03 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		int num1, num2;
		String in = null;
		while(true) {
			System.out.printf("===���� ���α׷�===\n������ �Է� (+,-,*,/) [q = ����] : ");
			in = sc.nextLine();
			if(in.equals("q")) {exit();}
			if(in.equals("+")||in.equals("-")||in.equals("*")||in.equals("/")) {
				num1 = validNum("ù ��° ���� : ");
				num2 = validNum("�� ��° ���� : ");
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
				System.out.println("�����ڸ� �ٽ� �Է����ּ���.");
				continue;
			}
		}
	}
	public static void plus(int num1, int num2) {
		int num3 = num1 + num2;
		System.out.printf("======�� ��======\n%d + %d = %d\n",num1,num2,num3);
		return;
	}
	public static void minus(int num1, int num2) {
		int num3 = num1 - num2;
		System.out.printf("======�� ��======\n%d - %d = %d\n",num1,num2,num3);
		return;
	}
	public static void multiple(int num1, int num2) {
		int num3 = num1 * num2;
		System.out.printf("======�� ��======\n%d * %d = %d\n",num1,num2,num3);
		return;
	}
	public static void division(double num1, double num2) {
		double num3 = num1 / num2;
		if(num1 % num2 != 0) {
			System.out.printf("======�� ��======\n%.0f / %.0f = %.2f\n",num1,num2,num3);
		} else {
			System.out.printf("======�� ��======\n%.0f / %.0f = %.0f\n",num1,num2,num3);
		}
		return;
	}
	public static void exit() {
		System.out.println("���⸦ �����մϴ�.");
		System.exit(0);
	}
	public static int validNum(String s) {
		while(true) {
			try {
				System.out.print(s);
				String a = sc.nextLine(); // a : q �˻�� ����
				if (a.equals("q")) {exit();}
				return Integer.parseInt(a);
			} catch(Exception e) {
				System.out.println("���ڸ� �Է����ּ���.");
			}
		}
	}
}

//while(true) {
//	try {
//		System.out.print("ù ��° ���� : ");
//		num1 = Integer.parseInt(sc.nextLine());
//		break;
//	} catch(Exception e) {
//		System.out.println("���ڸ� �Է����ּ���.");
//	}
//}
//while(true) {
//	try {
//		System.out.print("�� ��° ���� : ");
//		num2 = Integer.parseInt(sc.nextLine());
//		break; // ���� ���� �Է� �� �� ���ѷ��� Ż��
//	} catch(Exception e) {
//		System.out.println("���ڸ� �Է����ּ���.");
//	}
//}