package exams;
import custom.Car;

public class Car_01 {
	public static void main(String[] args) {


	Car genesis = new Car();

	genesis.setPrice(60000000);
	genesis.setColor("Silver");
	genesis.setmodel("GV80");
	
	System.out.println(genesis.getModel());
	System.out.println(genesis.getColor());
	System.out.println(genesis.getPrice());
	
	genesis.getThis().getThis().getThis()
	//체인기법.. 자기 자신의 주소를 리턴하는 기법 
	}
}
