package exams;

import custom.Temp;

public class Exam_04 {

	public void func() {
		int a = 10;
	}


	public static void main(String[] args) {



		Temp t1 = new Temp();
		t1 = null; //�ν��Ͻ� ����� 
		
		
		Temp t2 = new Temp();

		t1.a = 10;
		t2.a = 20;


		System.out.println(t1.a);
		System.out.println(t2.a);

		t1.b = 4321;
		//Temp.b = 4321; << static ������ ����Ҷ��� Ŭ������ . ��� ��� !


		System.out.println(t2.b);// t1.b�� ���� t2.b�� ���� ����
		// static�� ���� ������ �ν��Ͻ����� ���� ������ !


	}

}
