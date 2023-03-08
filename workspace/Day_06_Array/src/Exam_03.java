import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam_03 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[] arr = new int[3];

		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] : ",i);
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int j = 0;
		System.out.println("입력된 값은 ");
		for(int i : arr) {
			j++;
			System.out.printf("arr[%d] : %d\n",j,i);
		}

		
//		System.out.print("y : ");
//		st = new StringTokenizer(br.readLine());
//		arr[1] = Integer.parseInt(st.nextToken());
//		System.out.print("z : ");
//		st = new StringTokenizer(br.readLine());
//		arr[2] = Integer.parseInt(st.nextToken());
//		bw.flush();
//		System.out.printf("입력된 값은\nx : %d\ny : %d\nz : %d\n",arr[0],arr[1],arr[2]);
	}
}
