package exams;

import custom.Temp;

public class Exam_04 {

	public void func() {
		int a = 10;
	}


	public static void main(String[] args) {



		Temp t1 = new Temp();
		t1 = null; //인스턴스 지우기 
		
		
		Temp t2 = new Temp();

		t1.a = 10;
		t2.a = 20;


		System.out.println(t1.a);
		System.out.println(t2.a);

		t1.b = 4321;
		//Temp.b = 4321; << static 변수를 사용할때는 클래스에 . 찍고 사용 !


		System.out.println(t2.b);// t1.b의 값과 t2.b의 값이 같음
		// static이 붙은 변수는 인스턴스끼리 값을 공유함 !


	}

}
