package classes;

public abstract class Member {

	private String memberName;
	private String memberGrade;
	private int memberID;
	private double memberPoint;

	public Member(int memberNum, String memberName, double point) {
		this.memberID = memberNum;
		this.memberName = memberName;
		this.memberPoint = point;
		this.memberGrade = "Default";
	}

	public void showInfo() {
		System.out.println("ȸ�� �̸� : " + this.memberName);
		System.out.println("ȸ�� ���̵� : " + this.memberID);
		System.out.println("ȸ�� ��� : " + this.memberGrade);
		System.out.println("���� ����Ʈ : " + this.memberPoint);
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void setMemberPoint(double memberPoint) {
		this.memberPoint = memberPoint;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public int getMemberID() {
		return memberID;
	}

	public double getMemberPoint() {
		return memberPoint;
	}

	public abstract double getBonus();
}
