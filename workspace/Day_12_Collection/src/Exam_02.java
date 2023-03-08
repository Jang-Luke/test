import java.util.ArrayList;

public class Exam_02 {
	public static void main(String[] args) {
		Object o;
		o = new ArrayList();  // Auto boxing
		o = new Exam_02();
		o = 10;
		o = new Integer(10);

		String str = "asafnqfnlkasf";
		str.length();
		
//		ArrayList<String> arr = new ArrayList<String>();
		ArrayList arr = new ArrayList();
		arr.add("Hello");
		arr.add("World");
		arr.add("Collection");
		arr.add(10);
		arr.add(3.14);
		arr.add(new Exam_02());
		arr.add(new ArrayList());
		
		((String)arr.get(2)).length();
		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		arr.remove(0);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		arr.add(1, "Java");
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
//		System.out.println(arr.size());
		
		ArrayList<String> arr2 = new ArrayList<>();
		arr2.add("Hello");
		arr2.add("World");
		arr2.add("Collection");
		
		for (String s : arr2) {
			System.out.println(s);
		}
	}
}
