import java.util.Scanner;

public class Quiz_06 {

	public static void main(String[] args) {

		// Hello Java While 문구를 화면에 13번 출력해보세요.
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.println("입력한 숫자만큼 \"Hello Java While\"을 반복합니다. 1 이상의 정수를 입력해주세요.");
		int j = sc.nextInt();
		while(i<j) {
			i++;
			System.out.println("Hello Java While" + (i));
		}
	}

}
