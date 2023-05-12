package e03_dependency;

public class Meat implements Materials {
	@Override
	public void describe() {
		System.out.println("저는 고기입니다.");
	}
}
