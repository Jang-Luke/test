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
	
	// 부모 클래스로부터 상속 받은 메서드를 무시하고 동일한 프로트타입을 다시 정의하면
	// 상속받은 메서드를 덮어씌우는 효과를 가진다.
}
