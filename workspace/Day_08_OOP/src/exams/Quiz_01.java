package exams;

public class Quiz_01 {
	public static void main(String[] args) {

		Calc c = new Calc();
		
		
		
		
		System.out.println(Calc.plus(10,20));  //30   
		System.out.println(c.minus(20,10));    //10
		System.out.println(Calc.mply(5,4));    //20
		System.out.println(c.divide(10,2));    //5.0
		
		//Calc. < 클래스에. 찍고 사용 !! static 변수를 사용할때
		//c. < 인스턴스를 사용할때 !! static <없음 		
		
	}
}
