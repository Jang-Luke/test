package kh.spring.elec;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.TV;

public class LGTV implements TV {
	
	private int price;
	private String brand;
	private Speaker speaker;
	
	public LGTV() {
		System.out.println("LG TV created");
	}
	public LGTV(int price, String brand, Speaker speaker) {
		System.out.println("LG TV created");
		this.price = price;
		this.brand = brand;
		this.speaker = speaker;
	}
	@Override
	public void powerOn() {
		System.out.println("LG powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("LG powerOff");
	}
	@Override
	public void volumnUp() {
		speaker.volumnUp();
	}
	@Override
	public void volumnDown() {
		speaker.volumnDown();
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public String getBrand() {
		return brand;
	}
}
