import java.util.Scanner;
public class Quiz_03_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			int player = 0;
			int com = ((int)(Math.random() * 2)+1);

			try {
				System.out.println("===���� ���� ��===");
				System.out.print("���ڸ� �����ϼ��� (1.���� / 2.���� /3. ��) : ");
				player = Integer.parseInt(sc.nextLine());

			}catch(Exception e) {
				System.out.println("���ڷ� �Է����ּ���");
				continue;
			}
			System.out.println("========= �� �� =========");

			switch(player) {

			case 1:
				System.out.println("�÷��̾�� ������ �½��ϴ�");
				break;
			case 2:
				System.out.println("�÷��̾�� ������ �½��ϴ�");
				break;
			case 3:
				System.out.println("�÷��̾�� ���� �½��ϴ�");
				break;
			default:
				System.out.println("��ȣ�� Ȯ�����ּ���");
				continue;
			}

			switch(com) {
			case 1:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
				break;
			case 2:
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
				break;
			case 3:
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�");
				break;
			}

			System.out.println("========================");

			if((player == 1 && com == 3) ||
					(player == 2 && com == 1) ||
					(player == 3 && com == 2)) {
				System.out.println("�÷��̾ �¸��߽��ϴ�");
			}
			else if ((com == 1 && player == 3) ||
					(com == 2 && player == 1) ||
					(com == 3 && player == 2)) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�");
			}
			else {
				System.out.println("�����ϴ�");
			}
		}
	}

}

