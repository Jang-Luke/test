import java.util.Scanner;

public class Quiz_09 {
     public static void main(String[] args) {
	
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("=== 1 ~ n������ �� ���ϱ� ===");
    	 System.out.print("n �Է� : ");
    	 int num1 = Integer.parseInt(sc.nextLine());
    	 
    	 int sum = 0;
    	 int num2 = 0;
    	 
    	 while(true) {
    		 if(sum >= num1)
    			 break;
    		 sum++;
    		 num2 += sum;
    	 }
    	 System.out.println("1 ~ " + num1 + "������ ���� " + num2 + "�Դϴ�.");
}
}
