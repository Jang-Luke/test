package custom;

// 클래스를 더 좋게 만드는 방법
// 정보은닉 - 접근제한자 [ public, protected, package, private ]
// 외부에 노출될 필요가 없는 정보를 private 키워드로 숨겨서
// 클래스 설계자의 의도대로 안정적인 클래스 운용이 가능하게 만드는 방식
// 클래스 설계자에게는 안정성을 제공할 수 있음.
// 사용자의 편의성에도 영향을 미침.

public class TV {
	
	private int price;
	private int channel;
	private double weight;
	private String brand;
	// 설계도에서 속성을 저장하는 변수 - 멤버 변수 (Member Field)

	public TV() {}
	// Default Constructor : 개발자가 생성자를 명시하지 않았을 경우, 내장되어 숨겨져 있는 생성자
	// Default Constructor는 개발자의 명시적 생성자에 의해 지워진다.
	
	public TV(String brand, int price, double weight) {
		this.brand = brand;
		this.price = price;
		this.weight = weight;
	}
	// Constructor - 생성자
	// 목적 - 만들어진 인스턴스에 초기값을 세팅하기 위한 목적으로 사용되는 메서드
	// 생성자 메서드의 이름은 크래스의 이름과 동일해야 한다.
	// 생성자 메서드는 여타 다른 메서드들과 다르게 return 값을 가질 수 없다.
	// 생성자 메서드는 다른 메서드들과 다르게 method call 타이밍을 선택할 수 없다.
	// 기타 특성은 일단 메서드와 동일하다.

	public void setChannel(int channel) {
		if (channel > 0) {
			this.channel = channel;
		}
	}

	public int getChannel() {
		return channel;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void powerON() {
	}

	public void powerOFF() {
	}
	// Member Method

	public void showChannel() {
		System.out.println(channel);
	}

	public void showTVInfo() {
		System.out.printf("%s브랜드 TV는 %d원이며, %.2fkg입니다.\n", brand, price, weight);
		return;
	}

	// Nested Class
}
