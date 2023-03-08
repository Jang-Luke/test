package classes;

public class Silver2 extends Member {

	public Silver2(int memberID, String memberName, double memberPoint) {
		super(memberID, memberName, memberPoint);
		setMemberGrade("Silver");
	}

	@Override
	public double getBonus() {
		return getMemberPoint() * 0.02;
	}
}
