package exam03;

import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Contact[] con = new Contact[3];
		int index = 0;

		while(true) {
			
			System.out.println("===�̸��� �Է�===");
			System.out.println("1.�Է�");
			System.out.println("2.���");
			System.out.println("3.�����");
			System.out.println("0.���α׷� ����");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {
				System.out.print("�̸��� �Է��ϼ���.");
				String name = sc.nextLine();
				System.out.println("��ȣ�� �Է��ϼ���.");
				String number = sc.nextLine();
				System.out.println("������ �Է��ϼ���.");
				String mail = sc.nextLine();

				con[index++] = new Contact(name,number,mail);
			}

			else if(num == 2) {

				if(index == 0) {
					System.out.println("�Էµ� ������ �����ϴ�.");
				}
				else {
					for(int i = 0; con[i] != null; i++) {
						System.out.println("�̸�\t��ȣ\t����");
						System.out.println(con[i].getName()+"\t"+con[i].getNums()+"\t"+con[i].getMail());
					}
				}
			}
			else if(num == 3) {   //���� ����� !
				
				if(index == 0) {
					System.out.println("������ ������ �����ϴ�.");
					continue;
				}
				con[--index] = null;
				System.out.println("���� �Ǿ����ϴ�.");

			}
			else if(num == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			else {
				System.out.println("��ȣ�� ����� �Է����ּ���.");
			}

		}
	}
}