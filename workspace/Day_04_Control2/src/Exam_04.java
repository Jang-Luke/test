import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {	

		Scanner sc = new Scanner(System.in);

		System.out.println("좋아하는 OTT는?");
		System.out.println("1.Netflix 2.Disney 3.Watcha");
		System.out.print(">> ");
		int select = Integer.parseInt(sc.nextLine());

		switch(select) {

		case 1:
			System.out.println("Netflix 더 글로리가 인기입니다.");
			break;
		case 2:
			System.out.println("Disney는 카지노가 인기입니다.");
			break;
		case 3: 
			System.out.println("Watcha는 모르겠습니다.");
			break;
	    default:
	    	System.out.println("메뉴를 다시 확인해주세요.");
		}
	}
}
