import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while(true) {

			int num = 0;
			int nan = 0;

			while(true) {
				try {
					System.out.println("===가위 바위 보 게임===");
					System.out.println("숫자를 선택하세요(1.가위/2.바위/3.보 : ");

					num = Integer.parseInt(sc.nextLine());
					
					break;
				} catch(Exception e) {
					System.out.println("번호를 입력해주세요.");
				}
			}
				double rand = Math.random();
				nan = ((int)(rand * 2)+1);

				System.out.println("======결과======");
				if ((num == 1) && nan == 2 ) {
					System.out.println("당신은 가위를 냈습니다.");
					System.out.println("컴퓨터는 바위를 냈습니다.");
					System.out.println("================");
					System.out.println("컴퓨터가 이겼습니다");
				}
				else if ((num == 1) && nan == num) {
					System.out.println("당신은 가위를 냈습니다");
					System.out.println("컴퓨터는 가위를 냈습니다");
					System.out.println("================");
					System.out.println("비겼습니다");
				}	
				else if	((num == 1) && nan == 3) {
					System.out.println("당신은 가위를 냈습니다");
					System.out.println("컴퓨터는 보를 냈습니다");
					System.out.println("================");
					System.out.println("당신이 이겼습니다");
				}
				else if ((num == 2) && nan == 1) {
					System.out.println("당신은 바위를 냈습니다");
					System.out.println("컴퓨터는 가위를 냈습니다");
					System.out.println("================");
					System.out.println("당신이 이겼습니다");
				}	
				else if ((num == 2) && num == nan) {
					System.out.println("당신은 바위를 냈습니다");
					System.out.println("컴퓨터는 바위를 냈습니다");	
					System.out.println("================");
					System.out.println("비겼습니다");
				}
				else if ((num == 2) && nan == 3) {
					System.out.println("당신은 바위를 냈습니다");
					System.out.println("컴퓨터는 보를 냈습니다");
					System.out.println("================");
					System.out.println("컴퓨터가 이겼습니다");
				}
				else if ((num == 3) && nan == 1) {
					System.out.println("당신은 보를 냈습니다");
					System.out.println("컴퓨터는 가위를 냈습니다");
					System.out.println("================");
					System.out.println("컴퓨터가 이겼습니다");
				}
				else if ((num == 3) && nan == 2) {
					System.out.println("당신은 보를 냈습니다");
					System.out.println("컴퓨터는 바위를 냈습니다");
					System.out.println("================");
					System.out.println("당신이 이겼습니다");
				}
				else if ((num == 3 ) && nan == 3) {
					System.out.println("당신은 보를 냈습니다");
					System.out.println("컴퓨터는 보를 냈습니다");
					System.out.println("================");
					System.out.println("비겼습니다");
				}
				else {
					System.out.println("번호를 잘 못 입력하셨습니다");
				}
			}
		}
	}
