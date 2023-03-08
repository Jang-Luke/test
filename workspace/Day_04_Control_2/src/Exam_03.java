import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam_03 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean flag = true;
		
		while(flag == true) {
			System.out.println("좋아하는 OTT는?");
			System.out.println("1. Netflix   2.Disney   3.Watcha");
			System.out.print(">>");
			st = new StringTokenizer(br.readLine());
			int select = Integer.parseInt((st.nextToken()));
			switch(select) {
				case 1: 
					System.out.println("Netflix는 글로리가 인기입니다.");
					flag = false;
					break;
				case 2: 
					System.out.println("Disney는 카지노가 인기입니다.");
					flag = false;
					break;			
				case 3: 
					System.out.println("Watcha는 모르겠습니다. 망했어요.");
					flag = false;
					break;
				default : 
					System.out.println("메뉴를 다시 확인해주세요.");
					flag = true;
					continue;
			}
		}
		//		Scanner sc = new Scanner(System.in);

	}
}
