
public class Exam_01 {
	public static void main(String[] args) {

	    here: while(true) {
		for(int i=1; i<=10; i++) { 
			System.out.println(i);
			if(i == 5) {
				break here;/// 실행되는 순간 for문을 탈출함, 자신이 속한 딱 하나의 반복문만 나감 
			}
		}
	}
}