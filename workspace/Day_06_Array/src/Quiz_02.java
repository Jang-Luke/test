import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_02 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stuCount = 3;
		String[] name = new String[stuCount];
		int[] kor = new int[stuCount];
		int[] eng = new int[stuCount];

		for(int i = 0; i < name.length; i++) {
			System.out.printf("%-2d번째 학생 이름 : ",i+1);
			name[i] = br.readLine();
			System.out.printf("%-5s학생 국어 : ",name[i]);
			kor[i] = Integer.parseInt(br.readLine());
			System.out.printf("%-5s학생 영어 : ",name[i]);
			eng[i] = Integer.parseInt(br.readLine());
		}
		System.out.printf("이름\t국어\t영어\t합계\t평균\n");
		for(int i = 0; i < name.length; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%.1f\n",name[i],kor[i],eng[i],(kor[i]+eng[i]),(kor[i]+eng[i])/2.0);
		}
	}
}
