import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 10000;
		int coke = 0;
		int cider = 0;
		int maesil = 0;
		int input = 0;
		int num = 0;

		while(true) {
			try {
			System.out.println("===== ���Ǳ� �ùķ����� =====");
			System.out.println("������� �����ϼ���.");
			System.out.println("1.�ݶ�(1000) 2.���̴�(800) 3.�Ž���(1500) 4.���� [0.����ǰȮ��]");
			num = Integer.parseInt(sc.nextLine());
			
			
			}catch (Exception e) {
				System.out.println("���ڷ� �Է����ּ���");
			}
			if(num == 0) {
				System.out.println("========����ǰ ���========");
				System.out.println("������ : " + money);
				System.out.println("�ݶ�: " + coke+"��");
				System.out.println("���̴�: " + cider+"��");
				System.out.println("�Ž���: " + maesil+"��");
				System.out.println("========================");
			}
			else if(num == 1) {
				while(true) {
				try {	
				System.out.println("� �����Ͻðڽ��ϱ�?");
				int sum = Integer.parseInt(sc.nextLine());
				int cokePay = 1000;
				input = sum * cokePay;
				
				if(money < input) {
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println("���� �ܾ� :" +money);
					
				}	
				coke = sum;
				money -= input;
				System.out.println("�ݶ� �����߽��ϴ�");
				System.out.println("�ݶ�: "+coke);
				System.out.println("������ -" + input);
				
				break;
				
				}catch(Exception e) {
				  System.out.println("����� �Է��ϼ���.");
			}
			}
			}
			else if(num == 2) {		
				System.out.println("� �����Ͻðڽ��ϱ�?");			
				int sum = Integer.parseInt(sc.nextLine());
				int ciderPay = 800;
				input = sum * ciderPay;
				if(money < input) {
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println("���� �ܾ� :" +money);
					continue;
				}	
				cider = sum;
				money -= input;
				System.out.println("���̴ٸ� �����߽��ϴ�");
				System.out.println("���̴�: "+cider);
				System.out.println("������ -" + input);
			}
			else if(num == 3) {
				System.out.println("� �����Ͻðڽ��ϱ�?");
				int sum = Integer.parseInt(sc.nextLine());
				int maesilPay = 1500;
				input = sum * maesilPay;

				if(money < input) {
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println("���� �ܾ� :" +money);
					continue;
				}			
				maesil = sum;
				money -= input;
				System.out.println("�Ž����� �����߽��ϴ�");
				System.out.println("�Ž�: "+maesil);
				System.out.println("������ -" + input);
			}
			else if(num == 4) {
				System.out.println("���Ǳ� �ùķ����͸� �����մϴ�");
				System.exit(0);
			}
			else {
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
}
