package exam02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();


		ArrayList <CafeMenu> cafemenus = manager.getCafeMenu();

		while(true) {

			System.out.println("===ī�� �޴� �Է�===");
			System.out.println("1.�޴� �Է�");
			System.out.println("2.�޴� ���");
			System.out.println("3.�޴� ����");
			System.out.println("4.�޴� ����");
			System.out.println("5.�޴� �˻�");
			System.out.println("0.�ý��� ����");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {

				System.out.print("��ǰ��ȣ�� �Է��ϼ���.");
				int goodsnum = Integer.parseInt(sc.nextLine());

				System.out.print("�޴��� �Է��ϼ���.");
				String menu = sc.nextLine();

				System.out.print("������ �Է��ϼ���.");
				int price = Integer.parseInt(sc.nextLine());

				manager.addMenu(new CafeMenu(goodsnum,menu,price));


			}else if(num == 2) {

				if(cafemenus.size() == 0) {
					System.out.println("��ϵ� �޴��� �����ϴ�.");
				}

				System.out.println("��ǰ��ȣ\t�޴�\t����");

				for(CafeMenu cafemenu : cafemenus) {
					System.out.println(cafemenu.getGoodsnum()+"\t"+
							           cafemenu.getMenu()+"\t"+
							           cafemenu.getPrice());					
				}							
			}else if(num == 3) {

				System.out.println("������ �޴��� �Է����ּ���.");

				String search = sc.nextLine();

				int index = manager.deleteIndex(search);

				if(index == -1) {
					System.out.println("������ �޴��� �����ϴ�.");

				}else {
					System.out.println("���� �Ϸ��߽��ϴ�.");
				}
				
			}else if(num == 4) {

				System.out.println("������ �޴��� �Է����ּ���.");

				String modi = sc.nextLine();

				int index = manager.getIndex(modi);

				if(index == -1) {
					System.out.println("������ �޴��� �����ϴ�.");
				}

				else {
					System.out.print("������ �޴� ��ȣ : ");
					int modiMenuNum = Integer.parseInt(sc.nextLine());

					System.out.print("������ �޴� �̸� : ");
					String modiMenu = sc.nextLine();

					System.out.print("������ �޴� ���� : ");
					int modiPrice = Integer.parseInt(sc.nextLine());

					manager.updateByIndex(index,new CafeMenu(modiMenuNum,modiMenu,modiPrice));
					
					System.out.println("���� �Ϸ� �ƽ��ϴ�.");
				}

			}else if(num == 5) {

				System.out.println("�˻��� �޴��� �Է����ּ���.");

				String search = sc.nextLine();

				ArrayList<CafeMenu> result = manager.getCafeMenu(search);

				System.out.println("��ȣ\t�޴�\t����");

				for(CafeMenu cafemenu : result ) {

					System.out.println(cafemenu.getGoodsnum() + "\t" +
							           cafemenu.getMenu() + "\t" +
							           cafemenu.getPrice());
				}
			}
			else if (num == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}

			else {
				System.out.println("��ȣ�� ����� �Է����ּ���.");
			}
		}	
	}
}
