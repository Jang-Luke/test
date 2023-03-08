package exams;
import custom.Car;
import custom.TV;

public class Exam_02 {
	public static void main(String[] args) throws Exception {

		TV lg = new TV();

		lg.setChannel(10);
		lg.setBrand("LG");
		lg.setPrice(1000000);
		lg.setWeight(22.5);
		
		System.out.println(lg.getChannel());
		System.out.println(lg.getBrand());
		System.out.println(lg.getPrice());
		System.out.println(lg.getWeight());

		System.out.println("------------------");

		Car hyundai = new Car();
		hyundai.setModel("Genesis GV80");
		hyundai.setColor("Gray");
		hyundai.setPrice(50000000);
		
		System.out.println(hyundai.getModel());
		System.out.println(hyundai.getColor());
		System.out.println(hyundai.getPrice());

		System.out.println("------------------");
		
		Car kia = new Car("K7", "White", 32000000);
		System.out.println(kia.getModel());
		System.out.println(kia.getColor());
		System.out.println(kia.getPrice());
		kia.getThis().getThis().getThis().getThis();
		// Chaining 기법. 자기 자신 인스턴스의 주소값을 return 받아서 다시 메서드를 콜 하는 기법
	}
}
