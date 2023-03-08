// 지역 변수는 선언된 지역 안에서만 유효함.
// 지역이 끝나는 것과 새로운 지역이 생성되는 것은 연관이 없음.
// 바깥 지역에서 선언된 변수는 내부 지역에서도 사용이 가능함. (반대는 불가능)
public class Exam_03 {

	public static void main(String[] args) {
		int a = 20;
		{ // 가
			System.out.println(a);
		}
		
	}

}
