import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_01 {

	public static void main(String[] args) {
		
		// try - catch : 예외처리 구문
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";

		while(true) {
			try {
				input = br.readLine();
				st = new StringTokenizer(input);
				int num = Integer.parseInt(st.nextToken());
				System.out.println("분석된 숫자는 : " + num);
			} catch(Exception e) {
				// 예외가 발생했을 때, 개발자가 취해주고자 하는 행동
				System.out.println("오류가 발생했습니다. 숫자를 입력해주세요.");
				continue;
			}
			System.exit(0);
		}
	}
}
