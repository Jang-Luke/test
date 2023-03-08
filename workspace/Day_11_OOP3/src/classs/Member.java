package classs;

abstract public class Member {  //부모 클래스, 상위 클래스 
	                            //abstract - 설계 목적 클래스 (인스턴스화 될 수 없음)
	                         
	private int id;
	private String name;
	private double point;
	
	public Member(int id, String name, double point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	abstract public double getBonus();   //계획,설계 메서드 abstract 붙여주기 ! - 추상메서드 
	                                     //클래스에도 abstract 붙여주기 !!
	                                     //콜 될 수 없음 
}
