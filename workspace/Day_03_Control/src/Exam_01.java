import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("\"당신이 좋아하는 과일은 무엇입니까?\"");
		System.out.println("1.사과\t2.망고\t3.딸기");
		System.out.print(">> ");
		int menu = Integer.parseInt(sc.nextLine());
		int i = menu - 1;
		if (menu == 1) {
			System.out.println("사과는 영어로 \"?????\" 입니다.");
			System.out.println("\"\" 안에 들어갈 올바른 영어 단어를 입력해주세요.");
		} else if (menu == 2) {
			System.out.println("망고는 영어로 \"?????\" 입니다.");
			System.out.println("\"\" 안에 들어갈 올바른 영어 단어를 입력해주세요.");
		} else if (menu == 3) {
			System.out.println("딸기는 영어로 \"?????\" 입니다.");
			System.out.println("\"\" 안에 들어갈 올바른 영어 단어를 입력해주세요.");
		} else {
			System.out.println("\"메뉴를 다시 확인해주세요.\"");
			return;
		}
		String ans = sc.nextLine();
		
//		switch (menu) {
//			case 1: if (ans.equals("apple")) {
//						System.out.println("정답입니다!");
//					} else {
//						System.out.println("오답입니다.");
//					}
//					break;
//			case 2: if (ans.equals("mango")) {
//						System.out.println("정답입니다!");
//				} else {
//						System.out.println("오답입니다.");
//				}
//					break;
//			case 3: if (ans.equals("strawberry")) {
//						System.out.println("정답입니다!");
//					} else {
//						System.out.println("오답입니다.");
//					}
//					break;
//		}
			
		if (menu == 1) {
			if (ans.equals("apple")) {
				System.out.println("정답입니다!");
			} else {
				System.out.println("오답입니다.");
			}
		} else if (menu == 2) {
			if (ans.equals("mango")) {
				System.out.println("정답입니다!");
			} else {
				System.out.println("오답입니다.");
			}
		} else if (menu == 3) {
			if (ans.equals("strawberry")) {
				System.out.println("정답입니다!");
			} else {
				System.out.println("오답입니다.");
			}
		}
	}
}