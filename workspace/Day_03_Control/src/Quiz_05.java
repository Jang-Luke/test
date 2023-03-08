
public class Quiz_05 {

	public static void main(String[] args) {
		int i = 0;
		while(i<100) {
			i++;
			if(i % 10 ==0) {
				System.out.println(i);
			} else {
				System.out.printf("%2d ",i);
			}
		}
	}
}