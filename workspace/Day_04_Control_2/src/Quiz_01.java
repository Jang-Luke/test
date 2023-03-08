import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean flag = true;
		int select = 0;
		int myCash = 0;
		int inputCash = 0;
		while(flag) {
			while (flag) {
				try {
					System.out.print("***ATM 시뮬레이터***\n1.  잔액조회\n2.  입금하기\n3.  출금하기\n4.  종료하기\n>> ");
					String input = br.readLine();
					select = Integer.parseInt(input);
					flag = false;
				} catch(Exception e) {
					System.err.println("<<Error : 숫자를 입력해주세요.>>");
				}
			}
			flag = true;
			switch(select) {
			case 1 :
				System.out.printf("현재 보유 잔액은 %d원 입니다.\n",myCash);
				break;
			case 2 :
				while(flag) {
					try {
						System.out.println("얼마를 입금하시겠습니까?");
						st = new StringTokenizer(br.readLine());
						inputCash = Integer.parseInt(st.nextToken());
						myCash += inputCash;
						flag = false;
					} catch(Exception e) {
						System.err.println("<<Error : 금액은 숫자로 입력해주세요.>>");
					}
				}
				System.out.printf("%d원이 입금되었습니다.\n현재 보유 잔액은 %d원 입니다.\n",inputCash,myCash);
				break;
			case 3 :
				while(flag) {
					try {
						System.out.println("얼마를 출금하시겠습니까");
						st = new StringTokenizer(br.readLine());
						inputCash = Integer.parseInt(st.nextToken());
						flag = false;
					} catch(Exception e) {
						System.err.println("<<Error : 금액은 숫자로 입력해주세요.>>");
					}
				}
				if(myCash - inputCash >=0) {
					myCash -= inputCash;
					System.out.printf("%d원이 출금되었습니다.\n현재 보유 잔액은 %d원 입니다.\n",inputCash,myCash);
				} else {
					System.err.println("<<잔액이 부족합니다.>>");
					System.out.printf("현재 보유 잔액은 %d원 입니다.\n",myCash);
				}
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default :
				System.err.println("<<메뉴를 확인해주세요.>>");
				break;
			}
			flag = true;
		}
		return;
	}
}
