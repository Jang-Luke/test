// sysyem.exit(0);
import java.util.*;

public class Quiz_07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		boolean switch1 = true;
//		while(switch1) {
		while(true) {
			System.out.println("=====구구단 출력 프로그램=====");
			System.out.println("=======exit :: 99=======");
			System.out.print("2 ~ 9단 중 선택 : ");
			int dan = sc.nextInt();
			if(dan == 99) {
				System.out.println("_______________________");
				System.out.println("|   프로그램을 종료합니다.   |");
				System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
				System.exit(0);
//				return;
			}
			System.out.println("_______________________");
			if(1 < dan && dan <= 9) {
				for(int i = 1; i < 10; i++) {
					System.out.printf("|%3d   * %3d   =   %3d|%n",dan,i,dan*i);
				} 
			} else {
				System.out.println("|  구구단 범위를 벗어났습니다. |");
			}
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
		}
	}
}