
public class Exam_05 {
	public static void main(String[] args) {

		int a = 10;
		// 대입연산자 규칙1. 우항이 좌항으로 대입된다. (예외없음)
		// 대입연산자 규칙 2. 그러므로 좌한은 반드시 공간이어야만 한다. (변수)

		int A = 10;
		int B = 20;
		// A += B; // A = A + B;
		// A -= B; // A = A - B;
		// A *= B; // A = A * B;
		// A /= B; // A = A / B;
		// A %= B; // A = A % B;

//		System.out.println("A : " + A);
//		System.out.println("B : " + B);

		// ++A; 전치형
		// A++; 후치형

//		System.out.println(A == B);
//		System.out.println(A != B);
//		System.out.println(A < B);
//		System.out.println(A > B);
//		System.out.println(A <= B);
//		System.out.println(A >= B);

		System.out.println(10 < A && A < 20);
		
//		논리 연산자는 shortcut 연산을 수행한다.
		
	}
}
