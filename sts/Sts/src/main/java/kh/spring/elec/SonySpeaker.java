package kh.spring.elec;

import kh.spring.interfaces.Speaker;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("Sony Speaker Created");
	}
	public void volumnUp() {
		System.out.println("Sony volumn up");
	}
	public void volumnDown() {
		System.out.println("Sony volumn down");
	}
}
