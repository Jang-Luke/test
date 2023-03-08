
public class Exam_02 {
	public static void main(String[] args) {

		// 난수 예제
		
		int rand = ((int)(Math.random()*3)*2); // 0 ~ 1.0 사이의 실수를 무작위로 생성
		
		
		// 난수 범위 공식
	    // 구하고자 하는 난수의 최소값을 X
		// 구하고자 하는 난수의 최대값을 Y
		//(int)(Math.random()*(Y-X+1)+X)
		System.out.println(rand);
		                    // (0~1.0) * 16
		
	}
}
