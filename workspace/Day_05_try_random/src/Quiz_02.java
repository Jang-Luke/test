import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {

			double rand = Math.random();  //�ݺ��� �ȿ� �־�� �ݺ��ؼ� ������ ����

			int num = 0;

			while(true) {
				try {
					System.out.println("===���� �� �� ���߱�===");
					System.out.println("���ڸ� �Է����ּ��� (1.�ո�/2.�޸�) : ");

					num = Integer.parseInt(sc.nextLine());
					if(num > 2 || num <1) {
						System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
						continue;// �ؿ� ���ǵ� ��� �ȵǰ� �ٽ� �ݺ������� ���ƿ� �� �ֵ��� �� 
					}
					break;//�ݺ��� ���� ������ !

				}catch(Exception e) {
					System.out.println("���ڸ� �Է����ּ���.");
				}
			}

			if(num == ((int)(rand * 2)+1)) {
				System.out.println("������ϴ�.");
			}
			else if (num != ((int)(rand * 2)+1)) {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}

		}
	}
}