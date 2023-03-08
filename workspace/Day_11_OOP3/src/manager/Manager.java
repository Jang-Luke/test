package manager;

import java.util.ArrayList;

import classes.*;

public class Manager {
	private ArrayList<Gold2> goldMembers = new ArrayList<Gold2>();
//	private Gold[] goldMembers = new Gold[10];
	private ArrayList<Silver2> silverMembers = new ArrayList<Silver2>();
//	private Silver[] silverMembers = new Silver[10];
	private int silverIndex = 0;
	private int goldIndex = 0;
	
	public Manager() {}
	
	// Overloading
//	public void Insert(Silver2 silverMembers) {
//		this.silverMembers[silverIndex++] =silverMembers;
//	}
	
	public void Insert(Silver2 silverMembers) {
		this.silverMembers.add(silverMembers);
	}
	
	public void Insert(Gold2 goldMembers) {
		this.goldMembers.add(goldMembers);
	}
	// Overloading
	
//	public void getMembers() {
//		for(Silver s : manager) {
//			s.showInfo();
//		}
//	}
	
	public ArrayList<Silver2> getSilverMembers() {
		return silverMembers;
	}
	
	public ArrayList<Gold2> getGoldMembers() {
		return goldMembers;
	}
	
	public int getSilverIndex() {
		return silverIndex;
	}
	
	public int getGoldIndex() {
		return goldIndex;
	}
}