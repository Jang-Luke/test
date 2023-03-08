
public class Exam_03 {

	public static void main(String[] args) {

		System.out.println("Hello world");
		System.out.println(100);
		System.out.println(3.14);
		System.out.println();
		
		func();
		func(1);
		func(1,2);
		func("Test");
		
		
		Function a = new Function();
		System.out.println(a.testNum);
		a.testNum += 1;
		System.out.println(a.testNum);
		Function b = new Function2();
		System.out.println(b.testNum);
		System.out.println(b.getTestNum());
	}
	
	// �⺻������ �ż����� �̸��� �ߺ��Ǿ �ȵ�.
	// ��, �ż����� �̸��� ���Ƶ� ���� �ٸ��ٴ°� �����ȴٸ� �ߺ��� �� ����. (ex. ���� �ٸ� ������ ���ڸ� ������ ���)
	
	// Method Overloading
	// �ż����� �Ű������� ���� �Ǵ� Ÿ�ӿ� ���� �ߺ��� �ż��� �̸��� �������� ����� �� �ִ� ���
	public static void func() {
		System.out.println("Hello");
	}
	public static void func(int a) {
		System.out.println("World");
	}
	public static void func(int a, int b) {
		System.out.println("Method");
	}
	public static void func(String str) {
		System.out.println("Overload");
	}
}

class Function {
	protected int testNum = 10;
	
	public Function() {
		this.testNum += 1;
	}
	
	public void increaseTestNum() {
		testNum++;
	}
	
	public int getTestNum() {
		return testNum;
	}
}
class Function2 extends Function {
	
	public int getTestNum() {
		return super.testNum*2;
	}
}