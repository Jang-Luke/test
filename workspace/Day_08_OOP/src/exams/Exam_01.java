package exams;
import custom.TV;

public class Exam_01 {

	public static void main(String[] args) {

		TV samsung;
		// TV �ν��Ͻ��� �����Ѵ�.		
		samsung = new TV();
		// new TV(); => TV �ν��Ͻ��� �ּҰ��� ������.
		// TV �ν��Ͻ��� �ּҸ� ������ ��Ƶд�.
		
		
		TV lg = new TV("LG", 1200000, 23.4);
		samsung.showTVInfo();
		lg.showTVInfo();
		
	}
}
