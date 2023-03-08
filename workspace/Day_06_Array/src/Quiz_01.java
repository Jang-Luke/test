import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Quiz_01 {
	public static void main(String[] args) throws IOException {
		// int 형 변수 100개를 arr1로 생성하고, 1부터 100까지 저장한 후 출력해보세요.
		
		int[] arr1 = new int[100];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = i+1;
			System.out.printf("arr1[%2d] : %-3d\n", i, arr1[i]);
		}
		System.out.println("----------------");
		// int 형 변수 100개를 arr2로 생성하고, 100부터 1까지 저장한 후 출력해보세요.
		
		int[] arr2 = new int[100];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = (arr2.length)-i;
			System.out.printf("arr2[%2d] : %-3d\n", i, arr2[i]);
		}
		System.out.println("----------------");
		// char 형 변수 26개를 arr3로 생성하고, 알파벳 A부터 Z까지 저장한 후 출력해보세요.
		
		char[] arr3 = new char[26];
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] = (char)(65 + i);
			System.out.printf("arr3[%2d] : %-3c\n", i, arr3[i]);
		}
		
		ArrayList<Integer> arr11 = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			arr11.add(i, ++i);
			System.out.printf("arr11[%2d] : %-3d\n",i,arr11.get(i));
		}
	}
}
