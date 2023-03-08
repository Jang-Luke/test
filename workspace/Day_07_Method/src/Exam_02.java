
public class Exam_02 {
	public static void main(String[] args) {
		
		String str = "AH e l A l oA";
		System.out.println(str.length());
		
		char str2;
		str2 = str.charAt(0); // str 의 index (int) 번째 문자를 char 형으로 변환
		System.out.println(str2);
		
		int a = str.indexOf('w',2);
		System.out.println(a);// 2
		System.out.println(str.startsWith("A")); // true
		System.out.println(str.startsWith("e")); // false
		System.out.println(str.startsWith("e",2)); // true
		System.out.println(str.endsWith("A")); // true
		System.out.println(str.endsWith("o")); // false
		System.out.println(str.equals("AHelAloA")); // true
		System.out.println(str.equals("Hello")); // false
		System.out.println(str.contains("A")); // true
		System.out.println(str.contains("Al")); // true
		System.out.println(str.contains("Ae")); // false
		System.out.println(str.contains("b")); // false
		System.out.println(str.contains("HelA")); // true
		
		String sArr[] = new String[1];
		sArr = str.split(" ");
		for(int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i]);
		}
	}
}
