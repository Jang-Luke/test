
public class Exam_01 {
	public static void main(String[] args) {

	    here: while(true) {
		for(int i=1; i<=10; i++) { 
			System.out.println(i);
			if(i == 5) {
				break here;/// ����Ǵ� ���� for���� Ż����, �ڽ��� ���� �� �ϳ��� �ݺ����� ���� 
			}
		}
	}
}