package custom;

public class Temp {
	
	//Temp 인스턴스를 만들어야 안에 있는 메서드를 사용 할 수 있음
	//하지만 static 메서드는 사용 가능 !
	public int a;                //Instance Member Field(Instance에 종속된 멤버필드)
	                             //Temp t = new Temp(); <Temp 인스턴스를 만들어줘야
	                             //int a 도 사용할 수 있음

	public static int b;         //Class Member Field(이미 존재하는 변수)
	                             // static << 정적변수 !! 메인이 시작되고 그자리에 고정적으로 유지됨
	                             // 정적변수는 지워지지 않음 (프로그램 끝날때까지 유지되어야 하는 값을
	                             //                      쓸때 많이 씀)
	                             // static 멤버필드는 인스턴스에 포함되지 않음!
	                             // static이 붙으면 인스턴스끼리 공유됨 
	                             //전역변수(중괄호에 제한 받지 않고 아무데서나 사용해야 할때 씀)임!

   

	public static void func2() {
		a = 10;
	}
}