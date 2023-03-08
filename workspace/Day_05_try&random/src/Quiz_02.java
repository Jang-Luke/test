import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int instStat = 0;
		while(true) {
			int coinStat = (int)(Math.random()*2)+1;
			System.out.printf("===동전 앞 뒤 맞추기===\n숫자를 입력해주세요. (1. 앞면 / 2. 뒷면 / 3. 종료) : ");
			while(true) {
				try {
					st = new StringTokenizer(br.readLine());
					instStat = Integer.parseInt(st.nextToken());
					if (instStat == 3) {System.out.println("프로그램을 종료합니다."); System.exit(0);}
					else if (instStat != 1 && instStat != 2) {
						error();
						continue;
					}
				}catch(Exception e) {
					error();
					continue;
				}
				if (instStat == 1 || instStat ==2) {
					if (coinStat == instStat) {
						System.out.println("맞췄습니다 ^^");
						break;
					} else if (coinStat != instStat){
						System.err.print("땡! 틀렸습니다!\n");
						System.out.print("숫자를 다시 입력하세요. (1. 앞면 / 2. 뒷면 / 3. 종료) : ");
						continue;
					}
				} 
			}
			System.out.println("-------------> resstart");
		}
	}
	public static void error() {
		System.err.print("<<숫자를 다시 입력해주세요!>>\n");
		System.out.print("(1. 앞면 / 2. 뒷면 / 3. 종료)");
		return;
	}
}
