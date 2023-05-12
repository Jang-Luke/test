package e03_dependency;

public class Human {
	
	public void cooking(Fire fire, Materials materials) {
		materials.describe();
	}
	
	public Fire makeFire() {
		return new Fire();
	}
	public void act() {
		Fire fire = makeFire();
		Materials meat = new Meat();
		cooking(fire, meat);
	}
}
