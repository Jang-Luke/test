import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int balance = 0; //잔액


		while(true) {
			int num = 0;
			try {
				System.out.println("***ATM 시뮬레이터***");
				System.out.println("1. 잔액조회");
				System.out.println("2. 입금하기");
				System.out.println("3. 출금하기");
				System.out.println("4. 종료하기");
				System.out.print(">> ");

				num = Integer.parseInt(sc.nextLine()); //번호 선택

				break;

			}catch(Exception e) {
				System.out.println("번호를 제대로 입력해주세요.");
			}
			if(num == 1) {
				System.out.println("현재 보유 잔액은 " + balance + "원 입니다.");
			}

			else if (num == 2) {
				
				while(true) {
					try {
						System.out.println("얼마를 입금하시겠습니까?");
						int input = Integer.parseInt(sc.nextLine()); //입금 금액 입력
						balance += input; //입금 금액을 잔액에 더함
						System.out.println(input + "원이 입금되었습니다.");

						break;

					} catch (Exception e) {
						System.out.println("잘못 입력하셨습니다.");
					}
				}
			}			
			else if (num == 3) {
				while(true) {
					try {
						System.out.println("얼마를 출금하시겠습니까?");
						int input = Integer.parseInt(sc.nextLine()); // 출금 금액 
						if(balance < input) {     //출금 금액이 잔액을 넘을시 잔액 부족 출력
							System.out.println("잔액이 부족합니다.");
							continue; // 잔액 부족시 ~원을 출금했습니다. 내용이 출력되지 않게 건너뛰기
						}
						balance -= input; // 잔액에서 출금금액을 뺌

						System.out.println(input + "원을 출금했습니다.");

						break;

					}catch(Exception e) {
						System.out.println("잘못 입력 하셨습니다.");
					}
				}
			}
			else if(num == 4) {
				System.out.println("시뮬레이터를 종료합니다.");
				System.exit(4);  //시스템 종료
			}
			else {
				System.out.println("번호를 잘못 입력하셨습니다.");	
			}
		}
	}

}

