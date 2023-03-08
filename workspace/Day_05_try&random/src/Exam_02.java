
public class Exam_02 {
	public static void main(String[] args) {

		//난수 예제

		for(int i = 0; i < 100; i++) {
			double num1 = Math.random(); // 0.0 ~ 0.999999
			int ran = (int)(num1*16)+37;
//			if (ran > 95) {
//				System.out.println("성공!");
//				continue;
//			}
			System.out.println(ran);
		}
		// 37 ~ 52 사이의 난수를 출력하려면?
		// 난수 범위 공식
		// 구하고자 하는 난수의 최소값을 X
		// 구하고자 하는 난수의 최대값을 Y
		// (Y-X+1) + X
		// ran * (52 - 37 + 1) + 1
	}
}
