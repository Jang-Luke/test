import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("메세지를 입력하세요 : ");
		String msg = sc.nextLine(); //msg에는 문자의 주소값이 들어가있음 
		
		if(msg.equals("Apple")) { //참조 자료형에서는 ==이 적합하지 않음 
			System.out.println("사과 입니다.");
		}
		else if(msg == "Strawberry") {
			System.out.println("딸기 입니다.");
		}
		else {
			System.out.println("메세지를 확인할 수 없습니다.");
		}
	}
}
