package classs;

public class Silver extends Member {    //자식 클래스, 하위 클래스  
	                                    //Member 필드가 없으나 member에 상속받아
	                                    // 존재함
	                                    // 상속은 한번에 하나밖에 되지 않음 .
	                                    // 단 여러차례에 걸쳐서 상속되는건 됨 
	
	public Silver(int id, String name, double point) {
		super(id,name,point);		
	}
	
	public double getBonus() {
		return this.getPoint() * 0.02; 
	}	                               //추상메서드를 상속받아 내용을 채움 
		                               //implement : 구현하다 
		                               //오버라이딩은 내용이 있는 메서드를 상속받아
		                               //새로 내용을 채워 넣는 것 !(무효화하다)
	
	
//	public double getBonus() {
//		return this.getPoint() * 0.02; -> 오버라이드된 메서드 
//	}
	//overrides : 무효화시키다
	// 부모 클래스로부터 상속 받은 메서드를 무시하고 동일한 프로토타입을 다시 정의하면
	// 상속받은 메서드를 덮어 씌우는 효과를 가진다.
	
	//오버로딩 vs 오버라이드의 차이 !! *****
}
