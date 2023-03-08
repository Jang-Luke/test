package classes;

public class Ruby extends Member {

	public Ruby(int memberID, String memberName, double memberPoint) {
		super(memberID, memberName, memberPoint);
		setMemberGrade("Ruby");
	}

	@Override
	public double getBonus() {
		return getMemberPoint() * 0.05;
	}
}
