import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		int total = 0;
		int menu = 0;
		int horse = 0;


		while(true) {

			int casy = 0;
			int bet = 0;
			int lotto = 0;

			try {
				System.out.println("�渶 ���ӿ� ���� ���� ȯ���մϴ�.");
				System.out.println("1.���� ����");
				System.out.println("2.�ܾ� ����");
				System.out.println("3.�ܾ� ��ȸ");
				System.out.println("4.����");
				System.out.print("�޴��� �������ּ���.>>");
				menu = Integer.parseInt(sc.nextLine());

			}catch(Exception e) {
				System.out.println("���ڷ� �Է��ϼ���");
				continue;
			}

			if(menu == 1) {
				System.out.println("!! �渶 ������ �����ϰڽ��ϴ� !!");
				System.out.println("1. ��� ����� ������ ���� �յ� ��");
				System.out.println("2. �̹� �� ������ ���� ���� ��");
				System.out.println("3. �ֱ� �������� �ſ��� ��");
				System.out.print("���� �ϰ� ���� ���� �������ּ���.>>");
				horse = Integer.parseInt(sc.nextLine());
				System.out.print("�󸶸� ���� �Ͻðڽ��ϱ�?>>");
				bet = Integer.parseInt(sc.nextLine());
			
			if(bet > total) {
				System.out.println("�ܾ��� �����մϴ�.");
				continue;
			}	
			int rand = ((int)(Math.random()*3)*2);

			lotto += bet * rand;
			total -= bet;
			total += lotto;
			
			if(rand == 0) {
				System.out.println("���ÿ� �����ϼ̽��ϴ�");
				System.out.println("���� �ݾ�" + bet +"���� ��� �����̽��ϴ�." );
			}
			else if(lotto > bet) {
				System.out.println("���ÿ� ���� �ϼ̽��ϴ�");
				System.out.println(lotto + "���� ������ϴ�.");
			}
			}
			else if(menu == 2) {
				System.out.print("�󸶸� �����Ͻðڽ��ϱ�? >>");
				casy = Integer.parseInt(sc.nextLine());
				total += casy;
				System.out.println(casy + "���� �����ƽ��ϴ�.");
			}
			else if(menu == 3) {
				System.out.println("������ �ܾ��� " + total + "�� �Դϴ�." );
			}
			else if(menu == 4) {
				System.out.println("������ �����մϴ�"); 
				System.exit(4);
			}
			else {
				System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
			}
		}
	}
}
