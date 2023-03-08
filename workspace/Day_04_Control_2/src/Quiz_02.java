import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Quiz_02 {

	public static int myMoney = 3000;
	public static int drinkCount1 = 0;
	public static int drinkCount2 = 0;
	public static int drinkCount3 = 0;
	public static String drink1 = "콜라";
	public static String drink2 = "사이다";
	public static String drink3 = "매실차";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int in = 0;
		
		int price1 = 1000;
		int price2 = 800;
		int price3 = 1500;
		
		while(true) {
			System.out.printf("======자판기 시뮬레이터======\n음료수를 선택하세요.\n1.%4s[%5d원]\n2.%4s[%5d원]\n3.%4s[%5d원]\n[0.소지품확인]  [9.소지금충전]\n[8.프로그램 종료]\n",drink1,price1,drink2,price2,drink3,price3);
			st = new StringTokenizer(br.readLine());
			in = Integer.parseInt(st.nextToken());
			if (in == 1) {
				drinkCount1++;
				buy(drink1, drinkCount1, price1);
			} else if (in == 2) {
				drinkCount2++;
				buy(drink2, drinkCount2, price2);
			} else if (in == 3) {
				drinkCount3++;
				buy(drink3, drinkCount3, price3);
			} else if (in == 0) {
				showMyBag();
			} else if (in == 9) {
				System.out.printf("충전할 금액을 입력해주세요.\n현재 소지금 [%5d원]\n",myMoney);
				in = Integer.parseInt(br.readLine());
				chargeMoney(in);
			} else if (in == 8) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			else {
				System.out.println("다시 입력해주세요.");
			}
		}

	}
	public static void buy(String drink, int drinkCount, int price) {
		if (myMoney >= price) {
			myMoney -= price;
			System.out.println(drink+"를 구매하였습니다.\n"+drink+": " + drinkCount +"개\n소지금 -" + price+"원");
			System.out.printf("현재 소지금 [%5d원]\n",myMoney);
		} else {
			System.out.printf("잔액이 부족합니다.\n현재 소지금 : [%5d원]\n",myMoney);
		}
	}
	public static void showMyBag() {
		System.out.printf("========소지품 목록========\n소지금 : [%5d원]\n%4s : %s개\n%4s : %s개\n%4s : %s개\n========================\n",myMoney,drink1,drinkCount1,drink2,drinkCount2,drink3,drinkCount3);
		return;
	}
	public static void chargeMoney(int money) {
		myMoney += money;
		System.out.printf("[%5d]원 충전되어 남은 잔액은 \n[%5d]원 입니다.\n",money,myMoney);
		return;
	}
}
