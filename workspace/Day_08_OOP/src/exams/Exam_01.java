package exams;
import custom.TV;

public class Exam_01 {

	public static void main(String[] args) {

		TV samsung;
		// TV 인스턴스를 생성한다.		
		samsung = new TV();
		// new TV(); => TV 인스턴스의 주소값이 리던됨.
		// TV 인스턴스의 주소를 변수에 담아둔다.
		
		
		TV lg = new TV("LG", 1200000, 23.4);
		samsung.showTVInfo();
		lg.showTVInfo();
		
	}
}
