package exam02;

public class CafeMenu {
                         //������� Default value -> constructor -> setter !!!
	private int goodsnum;// private int goodsnum = 0; default value!!(�⺻��) ���� �ȳ־��ָ� �⺻���� �� ���� 
	private String menu;
	private int price;
	
	public CafeMenu() {}

	
	//Source - Generate constructor using filed >> ������ �ڵ� ���� 
	public CafeMenu(int goodsnum, String menu, int price) {
		this.goodsnum = goodsnum;
		this.menu = menu;
		this.price = price;
	}
	public int getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
