import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam_04 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b, tmp;
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		
		System.out.println(a + " : " + b);
		tmp = a;
		a = b;
		b = tmp;
		System.out.println(a + " : " + b);
	}
}
