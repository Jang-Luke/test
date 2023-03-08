package quiz02;

import java.util.ArrayList;

public class Manager {
	private static Manager manager = new Manager();
	private ArrayList<Contact> contacts = new ArrayList<>();
	private ArrayList<Contact> search = new ArrayList<>();

	private Manager() {}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public ArrayList<Contact> getContact() {
		return contacts;
	}

	public int getSize() {
		return contacts.size();
	}

	public ArrayList<Contact> searchWithID(int id) {
		search.clear();
		for (Contact all : contacts) {
			if (all.getId() == id) {
				search.add(all);
			}
		}
		return search;
	}

	public int checkID(int id) {
		if (1000 < id && id < 1101) {
			for (Contact all : contacts) {
				if (all.getId() == id) {
					return -1;
				}
			}
			return 1;
		} else {return -1;}
	}
}
