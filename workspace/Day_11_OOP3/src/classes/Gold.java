package classes;

public class Gold {

	private String customerName;
	private String customerGrade;
	private int customerID = 0;
	private double customerPoint;
	
	
	
	public Gold() {}
	public Gold(int customerNum, String customerName, int point) {
		this.customerID = customerNum;
		this.customerName = customerName;
		this.customerPoint = point;
		this.customerGrade = "Gold";
	}
	
	public void showInfo() {
		System.out.println("회원 이름 : " + this.customerName);
		System.out.println("회원 아이디 : " + this.customerID);
		System.out.println("회원 등급 : " + this.customerGrade);
		System.out.println("보유 포인트 : " + this.customerPoint);
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
		return this.customerPoint * 0.04;
	}
}
