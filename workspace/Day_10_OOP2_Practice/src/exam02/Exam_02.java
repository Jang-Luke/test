package exam02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();


		ArrayList <CafeMenu> cafemenus = manager.getCafeMenu();

		while(true) {

			System.out.println("===카페 메뉴 입력===");
			System.out.println("1.메뉴 입력");
			System.out.println("2.메뉴 출력");
			System.out.println("3.메뉴 삭제");
			System.out.println("4.메뉴 수정");
			System.out.println("5.메뉴 검색");
			System.out.println("0.시스템 종료");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {

				System.out.print("상품번호를 입력하세요.");
				int goodsnum = Integer.parseInt(sc.nextLine());

				System.out.print("메뉴를 입력하세요.");
				String menu = sc.nextLine();

				System.out.print("가격을 입력하세요.");
				int price = Integer.parseInt(sc.nextLine());

				manager.addMenu(new CafeMenu(goodsnum,menu,price));


			}else if(num == 2) {

				if(cafemenus.size() == 0) {
					System.out.println("등록된 메뉴가 없습니다.");
				}

				System.out.println("상품번호\t메뉴\t가격");

				for(CafeMenu cafemenu : cafemenus) {
					System.out.println(cafemenu.getGoodsnum()+"\t"+
							           cafemenu.getMenu()+"\t"+
							           cafemenu.getPrice());					
				}							
			}else if(num == 3) {

				System.out.println("삭제할 메뉴를 입력해주세요.");

				String search = sc.nextLine();

				int index = manager.deleteIndex(search);

				if(index == -1) {
					System.out.println("삭제할 메뉴가 없습니다.");

				}else {
					System.out.println("삭제 완료했습니다.");
				}
				
			}else if(num == 4) {

				System.out.println("수정할 메뉴를 입력해주세요.");

				String modi = sc.nextLine();

				int index = manager.getIndex(modi);

				if(index == -1) {
					System.out.println("수정할 메뉴가 없습니다.");
				}

				else {
					System.out.print("수정할 메뉴 번호 : ");
					int modiMenuNum = Integer.parseInt(sc.nextLine());

					System.out.print("수정할 메뉴 이름 : ");
					String modiMenu = sc.nextLine();

					System.out.print("수정할 메뉴 가격 : ");
					int modiPrice = Integer.parseInt(sc.nextLine());

					manager.updateByIndex(index,new CafeMenu(modiMenuNum,modiMenu,modiPrice));
					
					System.out.println("수정 완료 됐습니다.");
				}

			}else if(num == 5) {

				System.out.println("검색할 메뉴를 입력해주세요.");

				String search = sc.nextLine();

				ArrayList<CafeMenu> result = manager.getCafeMenu(search);

				System.out.println("번호\t메뉴\t가격");

				for(CafeMenu cafemenu : result ) {

					System.out.println(cafemenu.getGoodsnum() + "\t" +
							           cafemenu.getMenu() + "\t" +
							           cafemenu.getPrice());
				}
			}
			else if (num == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}

			else {
				System.out.println("번호를 제대로 입력해주세요.");
			}
		}	
	}
}
