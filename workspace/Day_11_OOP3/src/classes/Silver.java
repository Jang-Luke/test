package classes;

public class Silver {
	
	private String customerName;
	private String customerGrade;
	private int customerID = 0;
	private double customerPoint;
	
	
	
	public Silver() {}
	public Silver(int customerID, String customerName, int point) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPoint = point;
		this.customerGrade = "Silver";
	}
	
	public void showInfo() {
		System.out.println("ȸ�� �̸� : " + this.customerName);
		System.out.println("ȸ�� ���̵� : " + this.customerID);
		System.out.println("ȸ�� ��� : " + this.customerGrade);
		System.out.println("���� ����Ʈ : " + this.customerPoint);
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public int getCustomerID() {
		return customerID;
	}
	public double getCustomerPoint() {
		return customerPoint;
	}
	
	public double getBonus() {
		return this.customerPoint * 0.02;
	}
	
}
