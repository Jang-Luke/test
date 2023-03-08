import java.util.Scanner;

public class Exam_09 {
   public static void main(String[] args) {
	
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("숫자 입력 : ");
	   String str = sc.nextLine();
	   
	   int num = Integer.parseInt(str);
	   System.out.println(num + 20);
     }
}
