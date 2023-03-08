
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
	
	// 기본적으로 매서드의 이름은 중복되어선 안됨.
	// 단, 매서드의 이름이 같아도 서로 다르다는게 구별된다면 중복될 수 있음. (ex. 서로 다른 형태의 인자를 가지는 경우)
	
	// Method Overloading
	// 매서드의 매개변수의 개수 또는 타임에 따라 중복된 매서드 이름도 구분지어 사용할 수 있는 기법
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