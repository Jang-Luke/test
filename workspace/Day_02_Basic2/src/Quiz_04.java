import java.util.Scanner;

public class Quiz_04 {
    public static void main(String[] args) {
			
    	Scanner sc = new Scanner(System.in);
    	
   	    System.out.println("===============");
   	    
   	    System.out.print("이  름 : ");
   	    String name = sc.nextLine();
   	    
   	    System.out.println("===============");
   	    
   	    System.out.print("국  어 : ");
   	    int kor = Integer.parseInt(sc.nextLine());
   	    //double kor = Double.parseDouble(sc.nextLine()); -->입력을 실수로 하고 싶을때
   	    //double kor = sc.nextInt();  ---> 버퍼에서 숫자만 가져감 sc.nextLine --> 버퍼에서 다 가져감 
   	    //sc.nextInt(); < 연달아서 있는건 괜찮음 
   	    System.out.print("영  어 : ");
   	    int eng = Integer.parseInt(sc.nextLine());
   	    
   	    System.out.print("수  학 : ");
   	    int math = Integer.parseInt(sc.nextLine());
   	    
   	    System.out.println("===============");
   	    
    	int totalScore = kor + eng + math;
    	System.out.println("합계 : " + totalScore);
    	
    	System.out.println("===============");
    	
    	double average = totalScore / 3.0; //실수형으로 나오기 위해서는 두 값 중 하나를 실수형으로 적을것 
    	System.out.println("평균 : " + average);
	}
}
