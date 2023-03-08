import java.util.Scanner;

public class Quiz_03 {
     public static void main(String[] args) {
		
    	 // 두 정수를 입력받아 덧셈한 결과를 출력하는 프로그램을 작성해주세요.
    	 
       Scanner sc = new Scanner(System.in);
   	   
   	   System.out.print("숫자 입력 : ");
   	   String str1 = sc.nextLine();
   	   int num1 = Integer.parseInt(str1);
   	   // int num1 = Integer.parseInt(sc.nextLine());--> 입력된 숫자를 String을 거치지 않고 바로 문자로 만듬
   	   
   	   
   	   System.out.print("숫자 입력 : ");
   	   String str2 = sc.nextLine();
   	   int num2 = Integer.parseInt(str2);
   	// int num2 = Integer.parseInt(sc.nextLine());
   	   
   	   int result = num1 + num2;
   	   System.out.println("두 숫자를 더한 결과는 " + result + "입니다.");
	}
}
