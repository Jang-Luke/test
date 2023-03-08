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
				System.out.println("경마 게임에 오신 것을 환영합니다.");
				System.out.println("1.게임 시작");
				System.out.println("2.잔액 충전");
				System.out.println("3.잔액 조회");
				System.out.println("4.종료");
				System.out.print("메뉴를 선택해주세요.>>");
				menu = Integer.parseInt(sc.nextLine());

			}catch(Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}

			if(menu == 1) {
				System.out.println("!! 경마 게임을 시작하겠습니다 !!");
				System.out.println("1. 우승 경력이 많지만 은퇴를 앞둔 말");
				System.out.println("2. 이번 달 성적이 제일 좋은 말");
				System.out.println("3. 최근 떠오르는 신예인 말");
				System.out.print("베팅 하고 싶은 말을 선택해주세요.>>");
				horse = Integer.parseInt(sc.nextLine());
				System.out.print("얼마를 베팅 하시겠습니까?>>");
				bet = Integer.parseInt(sc.nextLine());
			
			if(bet > total) {
				System.out.println("잔액이 부족합니다.");
				continue;
			}	
			int rand = ((int)(Math.random()*3)*2);

			lotto += bet * rand;
			total -= bet;
			total += lotto;
			
			if(rand == 0) {
				System.out.println("베팅에 실패하셨습니다");
				System.out.println("베팅 금액" + bet +"원을 모두 잃으셨습니다." );
			}
			else if(lotto > bet) {
				System.out.println("베팅에 성공 하셨습니다");
				System.out.println(lotto + "원을 얻었습니다.");
			}
			}
			else if(menu == 2) {
				System.out.print("얼마를 충전하시겠습니까? >>");
				casy = Integer.parseInt(sc.nextLine());
				total += casy;
				System.out.println(casy + "원이 충전됐습니다.");
			}
			else if(menu == 3) {
				System.out.println("고객님의 잔액은 " + total + "원 입니다." );
			}
			else if(menu == 4) {
				System.out.println("게임을 종료합니다"); 
				System.exit(4);
			}
			else {
				System.out.println("올바른 번호를 입력해주세요.");
			}
		}
	}
}
