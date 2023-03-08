
public class Exam_01 {
	// Method ���Ǻ�(Definition)
	static void plus(int n1, int n2) {
		System.out.printf("%-2d + %-2d = %-2d\n",n1,n2,n1+n2);
		return;
	}
	//
	static void plus(int n1, int n2, int n3) {
	// Method ������ Ÿ��
		System.out.printf("%-2d + %-2d + %-2d = %-2d\n",n1,n2,n3,n1+n2+n3);
		return;
	}
	static void  plus(int n1, int n2, int n3, int n4) {
		System.out.printf("%-2d + %-2d + %-2d + %-2d = %d\n",n1,n2,n3,n4,n1+n2+n3+n4);
		return;
	}
	static int plus(int n1, int n2, String e) {
		return n1+n2;
	}
	static int plus(int n1, int n2, int n3, String e) {
		return n1+n2+n3;
	}
	static int plus(int n1, int n2, int n3, int n4, String e) {
		return n1+n2+n3+n4;
	}
	static int minus(int n1, int n2) {
		return n1-n2;
	}
	static double divide(int n1, int n2) {
		return n1/(double)n2;
	}
	static int bigger(int n1, int n2) {
		if		(n1 > n2) {return n1;}
		else if (n1 < n2) {return n2;}
		else 			  {return 0;}
	}
	
	static String translate(String s) {
		if		(s.equals("���")) {return "Apple";}
		else if (s.equals("����")) {return "Strawberry";}
		else 					  {return "None";}
	}
	static void translate1(String s) {
		if		(s.equals("���")) {System.out.println("Apple"); return;}
		else if (s.equals("����")) {System.out.println("Strawberry"); return;}
		else 					  {System.out.println("None"); return;}
	}
	
	public static void main(String[] args) {
		int result = plus(10,5,"") + 5;
		plus(10,5);	// Method ȣ���(Call)
		// plus method �� �����ϴ� 10�� 5�� ����, �μ� (parameter, argument) �� �̶�� �θ���.
		// �޼��忡 ���޵Ǿ����� ���� �޴� ������ �Ű�������� �θ���. - plus(n1, n2) �� ���, n1�� n2 �� ���Ѵ�.
		// �޼����� ���� ������ �׻� �ش� �޼��尡 �� �� �����̴�.
		System.out.printf("%-2d + %-2d = %-2d\n",10,5,plus(10,5,""));
		System.out.printf("%-2d + %-2d = %-2d\n",10,5,result);
		plus(7,9);
		plus(4,6);
		plus(1,3,6);
		plus(6,8,4);
		plus(7,2,6,9);
		System.out.printf("%-2d + %-2d + %-2d + %-2d = %-2d\n",1,5,4,2,plus(1,5,4,2,""));

		System.out.println(minus(5,3));
		System.out.println(divide(5,3));
		System.out.println(bigger(1,3));
		System.out.println(bigger(1,1));
		System.out.println(bigger(5,2));
		System.out.println("����� ����� " + translate("���"));
		System.out.println("����� ����� " + translate("����"));
		System.out.println("������ ����� " + translate("����"));
		translate1("���");
		translate1("����");
		translate1("����");
	}
}
class E1 {
	public static void printo() {
		System.out.println("O");
	}
	public void printx() {
		System.out.println("X");
	}
}