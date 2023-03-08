import java.util.Scanner;
public class Quiz_03_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			int player = 0;
			int com = ((int)(Math.random() * 2)+1);

			try {
				System.out.println("===가위 바위 보===");
				System.out.print("숫자를 선택하세요 (1.가위 / 2.바위 /3. 보) : ");
				player = Integer.parseInt(sc.nextLine());

			}catch(Exception e) {
				System.out.println("숫자로 입력해주세요");
				continue;
			}
			System.out.println("========= 결 과 =========");

			switch(player) {

			case 1:
				System.out.println("플레이어는 가위를 냈습니다");
				break;
			case 2:
				System.out.println("플레이어는 바위를 냈습니다");
				break;
			case 3:
				System.out.println("플레이어는 보를 냈습니다");
				break;
			default:
				System.out.println("번호를 확인해주세요");
				continue;
			}

			switch(com) {
			case 1:
				System.out.println("컴퓨터는 가위를 냈습니다");
				break;
			case 2:
				System.out.println("컴퓨터는 바위를 냈습니다");
				break;
			case 3:
				System.out.println("컴퓨터는 보를 냈습니다");
				break;
			}

			System.out.println("========================");

			if((player == 1 && com == 3) ||
					(player == 2 && com == 1) ||
					(player == 3 && com == 2)) {
				System.out.println("플레이어가 승리했습니다");
			}
			else if ((com == 1 && player == 3) ||
					(com == 2 && player == 1) ||
					(com == 3 && player == 2)) {
				System.out.println("컴퓨터가 이겼습니다");
			}
			else {
				System.out.println("비겼습니다");
			}
		}
	}

}

