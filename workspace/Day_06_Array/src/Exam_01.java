import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam_01 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int[] arr1 = new int[] {10, 30, 40, 50, 20}; // arr은 참조변수 <--- 배열 생성 문법 : int형 변수 4개 생성
		// heap 메모리를 사용하는 변수 선언 시 'new' 사용, / String은 예외
		String[] arr2 = new String[] {"A", "B", "C", "D"};
		// arr[i] => i : 첨자(index)
		// offset => 기준점으로부터 ~ 얼만큼 떨어졌는가? // 배열의 첨자(index)는 offset을 의미한다.
//		arr1[0] = 10;
//		arr1[1] = 20;
//		arr1[2] = 30;
//		arr1[3] = 40;
//		arr2[0] ="A";
//		arr2[1] ="B";
//		arr2[2] ="C";
//		arr2[3] ="D";
		int instance = arr1[0];
		int max = arr1[0];
		int a = 1;
		System.out.println(arr1[1-1]);
		System.out.println(arr1[a]);
		System.out.println(arr1[(int)(Math.random()*3)]);
		System.out.println(arr1[Integer.parseInt(sc.nextLine())]);
		System.out.println(arr1[Integer.parseInt(br.readLine())]);
		System.out.println("-------------");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("-------------");
		for (int i : arr1) {
			System.out.println(i);
		}
		System.out.println("-------------");
		for (String rp : arr2) {
			System.out.println(rp);
		}
		for (int i : arr1) {
			if(max > i) {
				max = i;
			}
			instance = i;
		}
		System.out.println(max);
	}
}