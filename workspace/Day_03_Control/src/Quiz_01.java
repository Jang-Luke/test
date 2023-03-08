import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘의 점심메뉴를 선택하세요.");
		System.out.println("1.샌드위치   2.김밥   3.우육면");
		int menu = Integer.parseInt(sc.nextLine());
		// 선택한 메뉴에 따라, 가까운 가게 이름을 출력하는 프로그램 작성
		
		if (menu == 1 || menu == 2 || menu == 3) {
			if (menu == 1) {
				System.out.println("선택하신 메뉴 \"샌드위치\"의 가장 가까운 매장은 서브웨이 입니다.");
			} else if (menu == 2) {
				System.out.println("선택하신 메뉴 \"김밥\"의 가장 가까운 매장은 김밥일번가 입니다.");
			} else if (menu == 3) {
				System.out.println("선택하신 메뉴 \"우육면\"의 가장 가까운 매장은 우육면공방 입니다.");
			}
		} else {
			System.out.println("올바른 메뉴를 입력해주세요.");
		}
		
	}

}
