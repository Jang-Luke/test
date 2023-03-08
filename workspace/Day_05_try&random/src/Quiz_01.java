
public class Quiz_01 {

	public static void main(String[] args) {

		// 5 ~ 10 난수
		// (int)(Math.random() * (10-5+1)+5;
		// myRand(5, 10); <-- 5 ~ 10 사이의 난수
		for(int i = 0; i < 10; i++) {
			System.out.printf("%-4d%-4d%-4d%-4d\n",myRand(0,9),myRand(1,10),myRand(20,35),myRand(0,1));
			
//			System.out.printf("0 ~ 9 까지의 랜덤 수 : %d\n",(int)((Math.random()*10)));
//			System.out.printf("1 ~ 10 까지의 랜덤 수 : %d\n",(int)((Math.random()*10)+1));
//			System.out.printf("20 ~ 35 까지의 랜덤 수 : %d\n",(int)((Math.random()*16)+20));
//			System.out.printf("0 또는 1 : %d\n",(int)(Math.random()*2));
//			System.out.println("----------------------------------------");
		}
	}
	static int myRand(int n1, int n2) {
		return (int)(Math.random()*(n2-n1+1)+n1);
	}

}
