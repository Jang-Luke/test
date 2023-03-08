package manager;

import java.util.ArrayList;
import java.util.Arrays;

import classes.*;

public class Manager2 {
	private ArrayList<Member> members = new ArrayList<>();
	private ArrayList<String> grades = new ArrayList<String>(Arrays.asList("Silver", "Gold", "Ruby"));
	private ArrayList<Member> search = new ArrayList<>();

	public Manager2() {
	}

	// public void insert2(Member member) {
	// this.members.add(member);
	// }

	public void insert(String grade, int id, String name, double bonus) {
		if (grade.equals("Silver")) {
			this.members.add(new Silver2(id, name, bonus));
		} else if (grade.equals("Gold")) {
			this.members.add(new Gold2(id, name, bonus));
		} else if (grade.equals("Ruby")) {
			this.members.add(new Ruby(id, name, bonus));
		}
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public ArrayList<Member> getMembersByID(int id) {
		search.clear();
		for (Member member : members) {
			if (member.getMemberID() == id) {
				search.add(member);
			}
		}
		return search;
	}

	public ArrayList<Member> getMembersByName(String name) {
		search.clear();
		for (Member member : members) {
			if (member.getMemberName().equals(name)) {
				search.add(member);
			}
		}
		return search;
	}

	public ArrayList<Member> getGrade(String s) {
		search.clear();
		for (String grade : grades) {
			if (grade.equals(s)) {
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberGrade().equals(s)) {
						search.add(members.get(i));
					}
				}
				break;
			}
		}
		return search;
	}

	public int getIndexByID(int id) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberID() == id) {
				return i;
			}
		}
		return -1;
	}

	public int getIndexByName(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public void showMemberInfo(String s) {
		for (String grade : grades) {
			if (s.equals(grade)) {
				printMember(getGrade(s));
				break;
			} else if (s.equals("All")) {
				printMember(members);
				break;
			}
		}
	}

	public void removeMemberByID(int id) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberID() == id) {
				members.remove(i);
				break;
			}
		}
	}

	public void removeMemberByName(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberName().equals(name)) {
				members.remove(i);
				break;
			}
		}
	}

	public void searchMemberByID(int id) {
		printMember(getMembersByID(id));
	}

	public void searchMemberByName(String name) {
		printMember(getMembersByName(name));
	}

	public void printMember(ArrayList<Member> search) {
		for (Member out : search) {
			System.out.println(out.getMemberID() + "\t" + out.getMemberGrade() + "\t" + out.getMemberName() + "\t"
					+ out.getMemberPoint() + "\t" + out.getBonus());
		}
	}

	public void modifyMemberByID(int a, String grade, int id, String name, double bonus) {
		int index = getIndexByID(a);
		if (index == -1) {
			return;
		}
		insert(grade, id, name, bonus);
		members.set(index, members.get(members.size() - 1));
		members.remove(members.size() - 1);
	}

	public void modifyMemberByName(String s, String grade, int id, String name, double bonus) {
		int index = getIndexByName(s);
		if (index == -1) {
			return;
		}
		insert(grade, id, name, bonus);
		members.set(index, members.get(members.size() - 1));
		members.remove(members.size() - 1);
	}

	// public ArrayList<Member> getSilver() {
	// ArrayList<Member> silverM = new ArrayList<Member>();
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals("Silver")) {
	// silverM.add(members.get(i));
	// }
	// }
	// return silverM;
	// }
	//
	// public ArrayList<Member> getGold() {
	// ArrayList<Member> goldM = new ArrayList<Member>();
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals("Gold")) {
	// goldM.add(members.get(i));
	// }
	// }
	// return goldM;
	// }
	//
	// public ArrayList<Member> getRuby() {
	// ArrayList<Member> rubyM = new ArrayList<Member>();
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals("Ruby")) {
	// rubyM.add(members.get(i));
	// }
	// }
	// return rubyM;
	// }

	// public void showSilverMemberInfo() {
	// ArrayList<Member> silverMembers = getSilver();
	// for (int i = 0; i < silverMembers.size(); i++) {
	// System.out.println(silverMembers.get(i).getMemberID() + "\t" +
	// silverMembers.get(i).getMemberGrade() + "\t" +
	// silverMembers.get(i).getMemberName() + "\t" +
	// silverMembers.get(i).getMemberPoint() + "\t" +
	// silverMembers.get(i).getBonus());
	// }
	// }
	//
	// public void showGoldMemberInfo() {
	// ArrayList<Member> goldMembers = getGold();
	// for (int i = 0; i < goldMembers.size(); i++) {
	// System.out.println(goldMembers.get(i).getMemberID() + "\t" +
	// goldMembers.get(i).getMemberGrade() + "\t" +
	// goldMembers.get(i).getMemberName() + "\t" +
	// goldMembers.get(i).getMemberPoint() + "\t" +
	// goldMembers.get(i).getBonus());
	// }
	// }
	//
	// public void showRubyMemberInfo() {
	// ArrayList<Member> rubyMembers = getRuby();
	// for (int i = 0; i < rubyMembers.size(); i++) {
	// System.out.println(rubyMembers.get(i).getMemberID() + "\t" +
	// rubyMembers.get(i).getMemberGrade() + "\t" +
	// rubyMembers.get(i).getMemberName() + "\t" +
	// rubyMembers.get(i).getMemberPoint() + "\t" +
	// rubyMembers.get(i).getBonus());
	// }
	// }

	// public void showAllMemberInfo() {
	// for (int i = 0; i < members.size(); i++) {
	// System.out.println(members.get(i).getMemberID() + "\t" +
	// members.get(i).getMemberGrade() + "\t" +
	// members.get(i).getMemberName() + "\t" +
	// members.get(i).getMemberPoint() + "\t" +
	// members.get(i).getBonus());
	// }
	// }
	// public ArrayList<Member> getGrade(String s) {
	// ArrayList<Member> search = new ArrayList<>();
	// if (s.equals("Silver")) {
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals(s)) {
	// search.add(members.get(i));
	// }
	// }
	// }
	// else if (s.equals("Gold")) {
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals(s)) {
	// search.add(members.get(i));
	// }
	// }
	// }
	// else if (s.equals("Ruby")) {
	// for (int i = 0; i < members.size(); i++) {
	// if(members.get(i).getMemberGrade().equals(s)) {
	// search.add(members.get(i));
	// }
	// }
	// }
	// return search;
	// }
}