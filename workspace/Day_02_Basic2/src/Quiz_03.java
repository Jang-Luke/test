import java.util.Scanner;

public class Quiz_03 {
     public static void main(String[] args) {
		
    	 // �� ������ �Է¹޾� ������ ����� ����ϴ� ���α׷��� �ۼ����ּ���.
    	 
       Scanner sc = new Scanner(System.in);
   	   
   	   System.out.print("���� �Է� : ");
   	   String str1 = sc.nextLine();
   	   int num1 = Integer.parseInt(str1);
   	   // int num1 = Integer.parseInt(sc.nextLine());--> �Էµ� ���ڸ� String�� ��ġ�� �ʰ� �ٷ� ���ڷ� ����
   	   
   	   
   	   System.out.print("���� �Է� : ");
   	   String str2 = sc.nextLine();
   	   int num2 = Integer.parseInt(str2);
   	// int num2 = Integer.parseInt(sc.nextLine());
   	   
   	   int result = num1 + num2;
   	   System.out.println("�� ���ڸ� ���� ����� " + result + "�Դϴ�.");
	}
}
