import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_03 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int select = 0;

		while(true) {
			int com = (int)((Math.random()*3+1)); // 1가위 < 2바위 < 3보 < 1가위
			String comStat = "";
			String userStat = "";
			switch (com) {
			case 1: comStat = "가위"; break;
			case 2: comStat = "바위"; break;
			case 3: comStat = "보"; break;
			}
			while(true) {
				try {
					System.out.printf("====가위 바위 보 게임====\n숫자를 선택하세요.(1.가위/2.바위/3.보/0.종료) : ");
					st = new StringTokenizer(br.readLine());
					select = Integer.parseInt(st.nextToken());
					break;
				} catch (Exception e) {
					System.out.printf("숫자를 다시 입력해주세요.\n");
				}
			}
			switch (select) {
			case 1: userStat = "가위"; break;
			case 2: userStat = "바위"; break;
			case 3: userStat = "보"; break;
			}
			if (select == 0) {System.out.print("프로그램을 종료합니다."); System.exit(0);}
			if(select == 1 || select == 2 || select == 3) {
				System.out.printf("=======결과=======\n당신은 %-2s를 냈습니다.\n컴퓨터는 %-2s를 냈습니다.\n================\n",userStat,comStat);
				judge(com, select);
			} else {
				System.out.println("숫자를 다시 입력해주세요.");
			}
		}
	}
	
	
	public static void judge(int com, int user) {
//		if (com == user) {draw();}
//		if (com == 1 && user == 2) {
//			win();
//		} else if (com == 1 && user == 3) {
//			lose();
//		}
//		if (com == 2 && user == 3) {
//			win();
//		} else if (com == 2 && user == 1) {
//			lose();
//		}
//		if (com == 3 && user == 1) {
//			win();
//		} else if (com == 3 && user == 2) {
//			lose();
//		}
		if((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
			win();
		} else if ((user == 3 && com == 1) || (user == 1 && com == 2) || (user == 2 && com == 3)) {
			lose();
		} else {
			draw();
		}
	}
	public static void win() {
		System.out.println("당신이 이겼습니다!");
	}
	public static void lose() {
		System.out.println("컴퓨터가 이겼습니다. ㅠㅠ");
	}
	public static void draw() {
		System.out.println("무승부입니다.");
	}
}
/*
if((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
	win();
} else if (user == 3 && com == 1) || (user == 1 && com == 2) || (user == 2 && com == 3) {
	lose();
} else {
	draw();
}
 */
