package exam03;

public class Contact {

	private String name;
	private String nums;
	private String mail;


	public Contact() {}

	public Contact(String name, String nums, String mail) {
		this.name = name;
		this.nums = nums;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
