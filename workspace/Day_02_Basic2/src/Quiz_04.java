import java.util.Scanner;

public class Quiz_04 {
    public static void main(String[] args) {
			
    	Scanner sc = new Scanner(System.in);
    	
   	    System.out.println("===============");
   	    
   	    System.out.print("��  �� : ");
   	    String name = sc.nextLine();
   	    
   	    System.out.println("===============");
   	    
   	    System.out.print("��  �� : ");
   	    int kor = Integer.parseInt(sc.nextLine());
   	    //double kor = Double.parseDouble(sc.nextLine()); -->�Է��� �Ǽ��� �ϰ� ������
   	    //double kor = sc.nextInt();  ---> ���ۿ��� ���ڸ� ������ sc.nextLine --> ���ۿ��� �� ������ 
   	    //sc.nextInt(); < ���޾Ƽ� �ִ°� ������ 
   	    System.out.print("��  �� : ");
   	    int eng = Integer.parseInt(sc.nextLine());
   	    
   	    System.out.print("��  �� : ");
   	    int math = Integer.parseInt(sc.nextLine());
   	    
   	    System.out.println("===============");
   	    
    	int totalScore = kor + eng + math;
    	System.out.println("�հ� : " + totalScore);
    	
    	System.out.println("===============");
    	
    	double average = totalScore / 3.0; //�Ǽ������� ������ ���ؼ��� �� �� �� �ϳ��� �Ǽ������� ������ 
    	System.out.println("��� : " + average);
	}
}
