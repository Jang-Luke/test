import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Quiz_01 {
	public static void main(String[] args) throws IOException {
		// int �� ���� 100���� arr1�� �����ϰ�, 1���� 100���� ������ �� ����غ�����.
		
		int[] arr1 = new int[100];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = i+1;
			System.out.printf("arr1[%2d] : %-3d\n", i, arr1[i]);
		}
		System.out.println("----------------");
		// int �� ���� 100���� arr2�� �����ϰ�, 100���� 1���� ������ �� ����غ�����.
		
		int[] arr2 = new int[100];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = (arr2.length)-i;
			System.out.printf("arr2[%2d] : %-3d\n", i, arr2[i]);
		}
		System.out.println("----------------");
		// char �� ���� 26���� arr3�� �����ϰ�, ���ĺ� A���� Z���� ������ �� ����غ�����.
		
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
