package e04_association_aggregation;

public class Human {
	private Watch watch;
	private Glasses glasses;

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Glasses getGlasses() {
		return glasses;
	}

	public void setGlasses(Glasses glasses) {
		this.glasses = glasses;
	}

	public Human() {
	}

	public Human(Watch watch, Glasses glasses) {
		this.watch = watch;
		this.glasses = glasses;
	}
}
