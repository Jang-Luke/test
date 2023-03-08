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
			System.out.println("===== 자판기 시뮬레이터 =====");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1.콜라(1000) 2.사이다(800) 3.매실차(1500) 4.종료 [0.소지품확인]");
			num = Integer.parseInt(sc.nextLine());
			
			
			}catch (Exception e) {
				System.out.println("숫자로 입력해주세요");
			}
			if(num == 0) {
				System.out.println("========소지품 목록========");
				System.out.println("소지금 : " + money);
				System.out.println("콜라: " + coke+"개");
				System.out.println("사이다: " + cider+"개");
				System.out.println("매실차: " + maesil+"개");
				System.out.println("========================");
			}
			else if(num == 1) {
				while(true) {
				try {	
				System.out.println("몇개 구매하시겠습니까?");
				int sum = Integer.parseInt(sc.nextLine());
				int cokePay = 1000;
				input = sum * cokePay;
				
				if(money < input) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔액 :" +money);
					
				}	
				coke = sum;
				money -= input;
				System.out.println("콜라를 구매했습니다");
				System.out.println("콜라: "+coke);
				System.out.println("소지금 -" + input);
				
				break;
				
				}catch(Exception e) {
				  System.out.println("제대로 입력하세요.");
			}
			}
			}
			else if(num == 2) {		
				System.out.println("몇개 구매하시겠습니까?");			
				int sum = Integer.parseInt(sc.nextLine());
				int ciderPay = 800;
				input = sum * ciderPay;
				if(money < input) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔액 :" +money);
					continue;
				}	
				cider = sum;
				money -= input;
				System.out.println("사이다를 구매했습니다");
				System.out.println("사이다: "+cider);
				System.out.println("소지금 -" + input);
			}
			else if(num == 3) {
				System.out.println("몇개 구매하시겠습니까?");
				int sum = Integer.parseInt(sc.nextLine());
				int maesilPay = 1500;
				input = sum * maesilPay;

				if(money < input) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔액 :" +money);
					continue;
				}			
				maesil = sum;
				money -= input;
				System.out.println("매실차를 구매했습니다");
				System.out.println("매실: "+maesil);
				System.out.println("소지금 -" + input);
			}
			else if(num == 4) {
				System.out.println("자판기 시뮬레이터를 종료합니다");
				System.exit(0);
			}
			else {
				System.out.println("번호를 다시 확인해주세요.");
			}
		}
	}
}
