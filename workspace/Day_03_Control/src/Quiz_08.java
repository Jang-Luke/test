import java.util.*;

public class Quiz_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 ~ N 까지의 합계 구하기\nN 값을 입력해주세요. : ");
		int a = sc.nextInt();
		int result = 0;
		int i = 0;
		while(i < a) {
			i++;
			result += i;
		}
		
//		for(int i = 1; i <= a; i++) {
//			result += i;
//		}
		System.out.println("결과는 : " + result + "입니다.");
	}
}
