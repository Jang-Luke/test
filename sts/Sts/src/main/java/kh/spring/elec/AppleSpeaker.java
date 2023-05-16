package kh.spring.elec;

import kh.spring.interfaces.Speaker;

public class AppleSpeaker implements Speaker {

	@Override
	public void volumnUp() {
		System.out.println("Apple Speaker volumn up");
	}

	@Override
	public void volumnDown() {
		System.out.println("Apple Speaker volumn down");		
	}
}
