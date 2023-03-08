public class Quiz_01 {

	public static int myRand(int num1,int num2) {

		return (int)(Math.random()*(num2-num1+1)+num1);
	}

	public static void main(String[] args) {				

		for(int i = 0; i<10; i++) {
			System.out.println(myRand(0,9) + "\t"); // 0~9 사이의 난수
			System.out.println(myRand(1,10) + "\t"); // 1~10 사이의 난수
			System.out.println(myRand(20,35) + "\t"); //20~35 사이의 난수
			System.out.println(myRand(0,1) + "\t"); //0~1 사이의 난수 


		}
	}
}
