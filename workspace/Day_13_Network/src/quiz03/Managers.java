package quiz03;

import java.util.ArrayList;

public class Managers {
	private static final Managers manager = new Managers();
	ArrayList<Contact> contacts = new ArrayList<>();
	ArrayList<Contact> search = new ArrayList<>();

	private Managers() {}

	public static Managers getInstance() {
		return manager;
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public ArrayList<Contact> getAll(){
		return contacts;
	}
	
	public ArrayList<String> getConracts(ArrayList<Contact> c) {
		ArrayList<String> s = new ArrayList<>();
		for (int i = 0; i < c.size(); i++) {
			s.add(c.get(i).getId()+"\t"+c.get(i).getName()+"\t"+c.get(i).getPhone());
		}
		return s;
	}
	
	public int getSize() {
		return contacts.size();
	}

	public ArrayList<Contact> searchByName(String name){
		search.clear();
		for (Contact all : contacts) {
			if (all.getName().equals(name)) {
				search.add(all);
			}
		}
		return search;
	}
//	public void removeMemberByID(int id) {
//		for (int i = 0; i < members.size(); i++) {
//			if (members.get(i).getMemberID() == id) {
//				members.remove(i);
//				break;
//			}
//		}
//	}
	public boolean removeByID(int id) {
		int cnt = 0;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getId() == id) {
				contacts.remove(i);
				cnt++;
			}
		}
		if (cnt == 0) {return false;} else {return true;}
	}

	public int checkID(int id) {
		for (Contact all : contacts) {
			if (all.getId() == id) {
				return -1;
			}
		}
		return 1;
	}
}
