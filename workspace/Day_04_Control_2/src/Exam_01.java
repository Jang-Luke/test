
public class Exam_01 {

	public static void main(String[] args) {

		here: while(true) {
			for (int i = 1; i <= 10; i++) {
				System.out.printf("i = %d\n",i);
				if(i == 5) {
					break here;
				}
			}
		}
	}
}


// break 濡� �듅�젙 諛섎났臾몄쓣 吏��젙�빐�꽌 �깉異쒗븯�뒗 諛⑸쾿 
// = label break