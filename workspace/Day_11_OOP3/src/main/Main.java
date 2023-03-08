package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import classes.*;
import manager.Manager;

public class Main {

	public static void main(String[] args) {

		// 추상화
		// Collection

		// 회원관리 시스템
		// 등급 클래스 설계 (Silver)
		// 회원 아이디
		// 회원 이름
		// 회원 포인트
		// Getter / Setter / Constructor / Default Constructor / 정보은닉

		
		
		
		// 완성된 코드의 문제점 3가지
		// 코드 중복도 ( 유지 보수 문제점 ) - 상속 [ IS - A 관계 ]		<<해결>>
		// 코드 결합도 ( 유지 보수 문제점 ) - 다형성
		// 저장소						- Collection
		
		
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		int menu;
		while(true) {
			System.out.printf("==회원 관리 시스템==\n1. 신규 회원 등록\n2. 회원 정보 출력\n0. 종료\n>>");
			while(true) {
				try {
					menu = Integer.parseInt(sc.nextLine());
					break;
				} catch(Exception e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			if (menu == 1) {
				manager.Insert(new Silver2(1001, "Tom", 1000));
				manager.Insert(new Silver2(1002, "Jane", 2000));
				manager.Insert(new Silver2(1003, "Mike", 3000));
				manager.Insert(new Gold2(1004, "Susan", 4000));
			} else if (menu == 2) {
				ArrayList<Silver2> silverMembers = manager.getSilverMembers();
				ArrayList<Gold2> goldMembers = manager.getGoldMembers();
				System.out.println("ID\tGrade\tName\tPoint\tBonus");
				for(int i = 0; i < silverMembers.size(); i++) {
					System.out.println(silverMembers.get(i).getMemberID() + "\t" +
									   silverMembers.get(i).getMemberGrade() + "\t" +
									   silverMembers.get(i).getMemberName() + "\t" +
									   silverMembers.get(i).getMemberPoint() + "\t" +
									   silverMembers.get(i).getBonus());
//					members[i].showInfo();
				}
				for(int i = 0; i < goldMembers.size(); i++) {
					System.out.println(goldMembers.get(i).getMemberID() + "\t" +
									   goldMembers.get(i).getMemberGrade() + "\t" +
									   goldMembers.get(i).getMemberName() + "\t" +
									   goldMembers.get(i).getMemberPoint() + "\t" +
									   goldMembers.get(i).getBonus());
				}
			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다."); 
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");
				continue;
			}
		}
	}
}
