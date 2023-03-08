import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("1~100사이 입력 : ");
		int a = sc.nextInt();
		sc.nextLine();
		boolean plag = a % 2 == 0;
		System.out.println("====결과====");
		
		if (1 <= a && a <= 100) {
			if (plag == true) {
				System.out.println("입력한 수는 짝수입니다.");
			} else {
				System.out.println("입력한 수는 홀수입니다.");
			}
		} else {
			System.out.println("입력 범위를 확인해주세요.");
		}
	}

}
