package classes;

public class Gold2 extends Member {
	
	public Gold2(int memberID, String memberName, double memberPoint) {
		super(memberID, memberName, memberPoint);
		setMemberGrade("Gold");
	}
	
	@Override
	public double getBonus() {
		return this.getMemberPoint() * 0.04;
	}
	
	// �θ� Ŭ�����κ��� ��� ���� �޼��带 �����ϰ� ������ ����ƮŸ���� �ٽ� �����ϸ�
	// ��ӹ��� �޼��带 ������ ȿ���� ������.
}
