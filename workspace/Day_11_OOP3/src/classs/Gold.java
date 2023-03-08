package classs;

public class Gold extends Member{   //자식 클래스, 하위 클래스 

	public Gold(int id, String name, double point) {

		super(id,name,point);
	}

	public double getBonus() {
		return this.getPoint() * 0.04; 
	}	
} 
