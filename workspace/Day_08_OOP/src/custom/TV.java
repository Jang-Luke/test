package custom;

// Ŭ������ �� ���� ����� ���
// �������� - ���������� [ public, protected, package, private ]
// �ܺο� ����� �ʿ䰡 ���� ������ private Ű����� ���ܼ�
// Ŭ���� �������� �ǵ���� �������� Ŭ���� ����� �����ϰ� ����� ���
// Ŭ���� �����ڿ��Դ� �������� ������ �� ����.
// ������� ���Ǽ����� ������ ��ħ.

public class TV {
	
	private int price;
	private int channel;
	private double weight;
	private String brand;
	// ���赵���� �Ӽ��� �����ϴ� ���� - ��� ���� (Member Field)

	public TV() {}
	// Default Constructor : �����ڰ� �����ڸ� ������� �ʾ��� ���, ����Ǿ� ������ �ִ� ������
	// Default Constructor�� �������� ����� �����ڿ� ���� ��������.
	
	public TV(String brand, int price, double weight) {
		this.brand = brand;
		this.price = price;
		this.weight = weight;
	}
	// Constructor - ������
	// ���� - ������� �ν��Ͻ��� �ʱⰪ�� �����ϱ� ���� �������� ���Ǵ� �޼���
	// ������ �޼����� �̸��� ũ������ �̸��� �����ؾ� �Ѵ�.
	// ������ �޼���� ��Ÿ �ٸ� �޼����� �ٸ��� return ���� ���� �� ����.
	// ������ �޼���� �ٸ� �޼����� �ٸ��� method call Ÿ�̹��� ������ �� ����.
	// ��Ÿ Ư���� �ϴ� �޼���� �����ϴ�.

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
		System.out.printf("%s�귣�� TV�� %d���̸�, %.2fkg�Դϴ�.\n", brand, price, weight);
		return;
	}

	// Nested Class
}
