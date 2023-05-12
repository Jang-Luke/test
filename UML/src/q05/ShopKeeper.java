package q05;

import java.util.List;

public class ShopKeeper {
	private Cart cart;
	public ShopKeeper() {}
	
	public int makeBillPaper() {
		List<Item> itemList = cart.getItems();
		return itemList.stream()
				.mapToInt(Item::getItemPrice)
				.sum();
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void calculate(Calculator calculator) {
		calculator.calculate();
	}
}
