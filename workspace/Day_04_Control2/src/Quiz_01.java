import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int balance = 0; //�ܾ�


		while(true) {
			int num = 0;
			try {
				System.out.println("***ATM �ùķ�����***");
				System.out.println("1. �ܾ���ȸ");
				System.out.println("2. �Ա��ϱ�");
				System.out.println("3. ����ϱ�");
				System.out.println("4. �����ϱ�");
				System.out.print(">> ");

				num = Integer.parseInt(sc.nextLine()); //��ȣ ����

				break;

			}catch(Exception e) {
				System.out.println("��ȣ�� ����� �Է����ּ���.");
			}
			if(num == 1) {
				System.out.println("���� ���� �ܾ��� " + balance + "�� �Դϴ�.");
			}

			else if (num == 2) {
				
				while(true) {
					try {
						System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
						int input = Integer.parseInt(sc.nextLine()); //�Ա� �ݾ� �Է�
						balance += input; //�Ա� �ݾ��� �ܾ׿� ����
						System.out.println(input + "���� �ԱݵǾ����ϴ�.");

						break;

					} catch (Exception e) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					}
				}
			}			
			else if (num == 3) {
				while(true) {
					try {
						System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
						int input = Integer.parseInt(sc.nextLine()); // ��� �ݾ� 
						if(balance < input) {     //��� �ݾ��� �ܾ��� ������ �ܾ� ���� ���
							System.out.println("�ܾ��� �����մϴ�.");
							continue; // �ܾ� ������ ~���� ����߽��ϴ�. ������ ��µ��� �ʰ� �ǳʶٱ�
						}
						balance -= input; // �ܾ׿��� ��ݱݾ��� ��

						System.out.println(input + "���� ����߽��ϴ�.");

						break;

					}catch(Exception e) {
						System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					}
				}
			}
			else if(num == 4) {
				System.out.println("�ùķ����͸� �����մϴ�.");
				System.exit(4);  //�ý��� ����
			}
			else {
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");	
			}
		}
	}

}

