import java.util.Scanner;

public class Exam_08 {
     public static void main(String[] args) {
		
    	 // 문장을 입력받는 기능
    	 Scanner sc = new Scanner(System.in);
    	 
    	 // System.in.read(); 아직 정해지지 않은 숫자 하나 
    	 System.out.println("메세지를 남겨주세요. ");
    	 String str = sc.nextLine(); //아직 정해지지 않은 문자열 하나
    	 
    	 System.out.println("<< 당신이 남긴 메세지는 >>");
    	 System.out.println(str);
	}
}
