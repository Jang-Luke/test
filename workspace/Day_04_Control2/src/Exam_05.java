import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("�޼����� �Է��ϼ��� : ");
		String msg = sc.nextLine(); //msg���� ������ �ּҰ��� ������ 
		
		if(msg.equals("Apple")) { //���� �ڷ��������� ==�� �������� ���� 
			System.out.println("��� �Դϴ�.");
		}
		else if(msg == "Strawberry") {
			System.out.println("���� �Դϴ�.");
		}
		else {
			System.out.println("�޼����� Ȯ���� �� �����ϴ�.");
		}
	}
}
