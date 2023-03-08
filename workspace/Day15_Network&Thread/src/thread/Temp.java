package thread;

public class Temp {
	private static int a;
	public int b;

	public static void main(String[] args) {
		Temp temp1 = new Temp();
		Temp temp2 = new Temp();

		Temp.a = 100;
		temp1.b = 200;
		System.out.println(temp2.a); // 100
		System.out.println(temp2.b); // 0
	}
	public int getA() {
		return a;
	}
}
