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
			System.out.printf("===���� �� �� ���߱�===\n���ڸ� �Է����ּ���. (1. �ո� / 2. �޸� / 3. ����) : ");
			while(true) {
				try {
					st = new StringTokenizer(br.readLine());
					instStat = Integer.parseInt(st.nextToken());
					if (instStat == 3) {System.out.println("���α׷��� �����մϴ�."); System.exit(0);}
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
						System.out.println("������ϴ� ^^");
						break;
					} else if (coinStat != instStat){
						System.err.print("��! Ʋ�Ƚ��ϴ�!\n");
						System.out.print("���ڸ� �ٽ� �Է��ϼ���. (1. �ո� / 2. �޸� / 3. ����) : ");
						continue;
					}
				} 
			}
			System.out.println("-------------> resstart");
		}
	}
	public static void error() {
		System.err.print("<<���ڸ� �ٽ� �Է����ּ���!>>\n");
		System.out.print("(1. �ո� / 2. �޸� / 3. ����)");
		return;
	}
}
