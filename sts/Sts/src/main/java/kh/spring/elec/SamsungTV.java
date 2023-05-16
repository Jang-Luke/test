package kh.spring.elec;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.TV;

public class SamsungTV implements TV {

	private int price;
	private String brand;
	private Speaker speaker;
	
	
	
	public SamsungTV() {

	}
	
	
	public SamsungTV(int price, String brand, Speaker speaker) {
		this.price = price;
		this.brand = brand;
		this.speaker = speaker;
	}


	@Override
	public void powerOn() {
		System.out.println("Samsung powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("Samsung powerOff");
	}
	@Override
	public void volumnUp() {
		speaker.volumnUp();
	}
	@Override
	public void volumnDown() {
		speaker.volumnDown();
	}
	
	int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
