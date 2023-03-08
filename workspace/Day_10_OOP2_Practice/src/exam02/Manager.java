package exam02;

import java.util.ArrayList;

public class Manager {

	private ArrayList <CafeMenu> cafemenus = new ArrayList<>();

	public void addMenu(CafeMenu cafemenu) {
		cafemenus.add(cafemenu);
	}
	public ArrayList<CafeMenu> getCafeMenu() {
		return cafemenus;
	}

	public ArrayList<CafeMenu> getCafeMenu(String search) {

		ArrayList <CafeMenu> result = new ArrayList<>();

		for(CafeMenu cafemenu : cafemenus) {
			if(cafemenu.getMenu().equals(search)) {

				result.add(cafemenu);
			}
		}
		return result;
	}
	public int getIndex(String search) {

		for(int i = 0; i<cafemenus.size(); i++) {
			if(cafemenus.get(i).getMenu().equals(search)) {		
				return i;
			}	
		}
		return -1;
	}
	public int deleteIndex(String search) {

		int index = this.getIndex(search);

		if(index == -1) {
			return index;
		}
		else {
			cafemenus.remove(index);
			return 0;
		}
	}
	public void updateByIndex(int index, CafeMenu menu) {

		cafemenus.set(index,menu);
	}
}