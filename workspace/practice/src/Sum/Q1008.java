package Sum;

import java.util.*;

public class Q1008 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a>10) {
			return;
		}
		else if (a<0) {
			return;
		}
		else if (b>10) {
			return;
		}
		else if (b<0) {
			return;
		}
		System.out.println(a+b);
	}
}