package q05;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items = new ArrayList<>();

	public Cart() {
	}

	public Cart(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
}
