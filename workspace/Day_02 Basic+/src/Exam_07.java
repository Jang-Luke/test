import java.util.Scanner;

public class Exam_07 {

	public static void main(String[] args) {

		//문장을 입력받는 기능
		Scanner sc = new Scanner(System.in);
		String inputData;
		
		
		System.out.println("메세지를 남겨주세요.");
		inputData = sc.nextLine();
		
		System.out.println("<< 당신이 남긴 메세지는 >>");
		System.out.println(inputData);
	}
}