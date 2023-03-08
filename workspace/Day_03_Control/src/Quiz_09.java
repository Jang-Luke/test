import java.util.Scanner;

public class Quiz_09 {
     public static void main(String[] args) {
	
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("=== 1 ~ n까지의 합 구하기 ===");
    	 System.out.print("n 입력 : ");
    	 int num1 = Integer.parseInt(sc.nextLine());
    	 
    	 int sum = 0;
    	 int num2 = 0;
    	 
    	 while(true) {
    		 if(sum >= num1)
    			 break;
    		 sum++;
    		 num2 += sum;
    	 }
    	 System.out.println("1 ~ " + num1 + "까지의 합은 " + num2 + "입니다.");
}
}
