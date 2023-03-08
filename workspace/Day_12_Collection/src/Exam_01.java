
public class Exam_01 {
	public static void main(String[] args) {
		String[] arr = new String[10];
		arr[0] = "Hello";
		arr[1] = "World";
		arr[2] = "Collection";
		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(arr[i]);
//		}
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = null;
//		for (int i = 0; i < 3; i++) {
//			System.out.println(arr[i]);
//		}
		arr[2] = arr[1];
		arr[1] = "Java";
		for (int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr.length);
		A a = new A();
		System.out.println(a.a);
	}
}
class A {
	String a;
}