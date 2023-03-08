import java.io.IOException;
import java.util.Scanner;

public class Quiz_08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int koreanScore = 0;
		int englishScore = 0;
		int mathScore = 0;
//		double koreanScoreD = 0;
//		double englishScoreD = 0;
//		double mathScoreD = 0;
		
		
		
		System.out.println("===============");
		System.out.print("이 름 : ");
		in.nextLine();
		System.out.println("===============");
		System.out.print("국 어 : ");
		koreanScore = Integer.parseInt(in.nextLine());
//		koreanScoreD = Double.parseDouble(in.nextLine());	// 더블 형으로 입력 받는 코드 
//		koreanScore = in.nextInt();
//		in.nextLine();
		System.out.print("영 어 : ");
		englishScore = Integer.parseInt(in.nextLine());
//		englishScoreD = Double.parseDouble(in.nextLine());	// 더블 형으로 입력 받는 코드
//		englishScore = in.nextInt();
//		in.nextLine();
		System.out.print("수 학 : ");
		mathScore = Integer.parseInt(in.nextLine());
//		mathScoreD = Double.parseDouble(in.nextLine());	// 더블 형으로 입력 받는 코드
//		mathScore = in.nextInt();
		System.out.println("===============");
		System.out.println("합 계 : " + (koreanScore + englishScore + mathScore));
		System.out.printf("%s %.3f%n", "평 균 :", ((double) (koreanScore + englishScore + mathScore) / 3));
		System.out.println("===============");
	}
}