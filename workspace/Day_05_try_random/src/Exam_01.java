
public class Exam_01 {
	public static void main(String[] args) {

		// try - catch : 예외처리 구문
		try {

			int num = Integer.parseInt("123");
			System.out.println("분석된 숫자는 : " + num);

		}catch(Exception e) { 
			// 예외가 발생했을 때, 개발자가 취해주고자 하는 행동
			System.out.println("분석하는 데이터가 숫자의 형태가 아닙니다.");
		}
		System.out.println("프로그램 정상 종료");
	}
}