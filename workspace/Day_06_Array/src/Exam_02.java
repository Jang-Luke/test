import java.util.ArrayList;
import java.util.Arrays;

public class Exam_02 {

	public static void main(String[] args) {

		//int 형 변수 3칸 짜리를 arr1 로 작성하고, 0 : 48, 1 : 99, 2 : 33 을 저장한 후 화면에 출력해봅시다.

		int[] arr1 = new int[] {48, 99, 33};

		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr[" + i + "] : " + arr1[i]);
		}
		
		ArrayList<Integer> arr11 = new ArrayList<Integer>(Arrays.asList(48, 99, 33));
		arr11.add(3, 15);
		for(int j = 0; j < arr11.size(); j++) {
			arr11.set(j, arr11.get(j)*2);
			System.out.println(arr11.get(j));
		}
		//String 형 변수 2칸 짜리를 arr2 로 작성하고, 0 : "Hello", 1 : "World" 를 저장한 후 화면에 출력해봅시다.

		String[] arr2 = new String[] {"Hello", "World"};

		for(String a : arr2) {
			System.out.println(a);
		}

		//char 형 변수 5칸 짜리를 arr3 로 작성하고, 0 : 'A', 1 : 'r', 2 : 'r', 3 : 'a' ,4 : 'y' 를 저장한 후 화면에 출력해봅시다.
		
		char[] arr3 = new char[] {'A', 'r', 'r', 'a', 'y'};
		
		for(char b : arr3) {
			System.out.println(b);
		}
	}

}
