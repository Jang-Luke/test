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
	public static String drink1 = "�ݶ�";
	public static String drink2 = "���̴�";
	public static String drink3 = "�Ž���";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int in = 0;
		
		int price1 = 1000;
		int price2 = 800;
		int price3 = 1500;
		
		while(true) {
			System.out.printf("======���Ǳ� �ùķ�����======\n������� �����ϼ���.\n1.%4s[%5d��]\n2.%4s[%5d��]\n3.%4s[%5d��]\n[0.����ǰȮ��]  [9.����������]\n[8.���α׷� ����]\n",drink1,price1,drink2,price2,drink3,price3);
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
				System.out.printf("������ �ݾ��� �Է����ּ���.\n���� ������ [%5d��]\n",myMoney);
				in = Integer.parseInt(br.readLine());
				chargeMoney(in);
			} else if (in == 8) {
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
			else {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}

	}
	public static void buy(String drink, int drinkCount, int price) {
		if (myMoney >= price) {
			myMoney -= price;
			System.out.println(drink+"�� �����Ͽ����ϴ�.\n"+drink+": " + drinkCount +"��\n������ -" + price+"��");
			System.out.printf("���� ������ [%5d��]\n",myMoney);
		} else {
			System.out.printf("�ܾ��� �����մϴ�.\n���� ������ : [%5d��]\n",myMoney);
		}
	}
	public static void showMyBag() {
		System.out.printf("========����ǰ ���========\n������ : [%5d��]\n%4s : %s��\n%4s : %s��\n%4s : %s��\n========================\n",myMoney,drink1,drinkCount1,drink2,drinkCount2,drink3,drinkCount3);
		return;
	}
	public static void chargeMoney(int money) {
		myMoney += money;
		System.out.printf("[%5d]�� �����Ǿ� ���� �ܾ��� \n[%5d]�� �Դϴ�.\n",money,myMoney);
		return;
	}
}
