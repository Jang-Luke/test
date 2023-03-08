import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {

			double rand = Math.random();  //반복문 안에 있어야 반복해서 난수를 만들어냄

			int num = 0;

			while(true) {
				try {
					System.out.println("===동전 앞 뒤 맞추기===");
					System.out.println("숫자를 입력해주세요 (1.앞면/2.뒷면) : ");

					num = Integer.parseInt(sc.nextLine());
					if(num > 2 || num <1) {
						System.out.println("올바른 숫자를 입력해주세요.");
						continue;// 밑에 조건들 출력 안되고 다시 반복문으로 돌아올 수 있도록 함 
					}
					break;//반복문 빠져 나오기 !

				}catch(Exception e) {
					System.out.println("숫자를 입력해주세요.");
				}
			}

			if(num == ((int)(rand * 2)+1)) {
				System.out.println("맞췄습니다.");
			}
			else if (num != ((int)(rand * 2)+1)) {
				System.out.println("틀렸습니다.");
			}

		}
	}
}