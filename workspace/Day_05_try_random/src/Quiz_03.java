import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while(true) {

			int num = 0;
			int nan = 0;

			while(true) {
				try {
					System.out.println("===���� ���� �� ����===");
					System.out.println("���ڸ� �����ϼ���(1.����/2.����/3.�� : ");

					num = Integer.parseInt(sc.nextLine());
					
					break;
				} catch(Exception e) {
					System.out.println("��ȣ�� �Է����ּ���.");
				}
			}
				double rand = Math.random();
				nan = ((int)(rand * 2)+1);

				System.out.println("======���======");
				if ((num == 1) && nan == 2 ) {
					System.out.println("����� ������ �½��ϴ�.");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					System.out.println("================");
					System.out.println("��ǻ�Ͱ� �̰���ϴ�");
				}
				else if ((num == 1) && nan == num) {
					System.out.println("����� ������ �½��ϴ�");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
					System.out.println("================");
					System.out.println("�����ϴ�");
				}	
				else if	((num == 1) && nan == 3) {
					System.out.println("����� ������ �½��ϴ�");
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�");
					System.out.println("================");
					System.out.println("����� �̰���ϴ�");
				}
				else if ((num == 2) && nan == 1) {
					System.out.println("����� ������ �½��ϴ�");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
					System.out.println("================");
					System.out.println("����� �̰���ϴ�");
				}	
				else if ((num == 2) && num == nan) {
					System.out.println("����� ������ �½��ϴ�");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�");	
					System.out.println("================");
					System.out.println("�����ϴ�");
				}
				else if ((num == 2) && nan == 3) {
					System.out.println("����� ������ �½��ϴ�");
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�");
					System.out.println("================");
					System.out.println("��ǻ�Ͱ� �̰���ϴ�");
				}
				else if ((num == 3) && nan == 1) {
					System.out.println("����� ���� �½��ϴ�");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
					System.out.println("================");
					System.out.println("��ǻ�Ͱ� �̰���ϴ�");
				}
				else if ((num == 3) && nan == 2) {
					System.out.println("����� ���� �½��ϴ�");
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
					System.out.println("================");
					System.out.println("����� �̰���ϴ�");
				}
				else if ((num == 3 ) && nan == 3) {
					System.out.println("����� ���� �½��ϴ�");
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�");
					System.out.println("================");
					System.out.println("�����ϴ�");
				}
				else {
					System.out.println("��ȣ�� �� �� �Է��ϼ̽��ϴ�");
				}
			}
		}
	}
