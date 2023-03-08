package quiz03;

import java.util.ArrayList;

public class Manager {

	ArrayList<Contact> contact = new ArrayList<>();

	public void addId (Contact contact) {
		this.contact.add(contact);
	}

	public ArrayList<Contact> getId() {
		return contact;
	}

	public ArrayList<Contact> searchName(String search) {

		ArrayList <Contact> searching = new ArrayList<>();

		for(Contact contacts : contact) {
			if(contacts.getName().equals(search)) {
				searching.add(contacts);
			}	
		}
		return searching;
	}

	public int getIndex(int search) {

		for(int i = 0; i<contact.size(); i++) {
			if(contact.get(i).getId() == search) {		
				return i;
			}	
		}
		return -1;
	}

	public int deleteIndex(int search) {

		int index = this.getIndex(search);

		if(index == -1) {
			return index;
		}
		else {
			contact.remove(index);
			return 0;
		}
	}

}