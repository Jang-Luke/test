package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import classes.*;
import manager.Manager;

public class Main {

	public static void main(String[] args) {

		// �߻�ȭ
		// Collection

		// ȸ������ �ý���
		// ��� Ŭ���� ���� (Silver)
		// ȸ�� ���̵�
		// ȸ�� �̸�
		// ȸ�� ����Ʈ
		// Getter / Setter / Constructor / Default Constructor / ��������

		
		
		
		// �ϼ��� �ڵ��� ������ 3����
		// �ڵ� �ߺ��� ( ���� ���� ������ ) - ��� [ IS - A ���� ]		<<�ذ�>>
		// �ڵ� ���յ� ( ���� ���� ������ ) - ������
		// �����						- Collection
		
		
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		int menu;
		while(true) {
			System.out.printf("==ȸ�� ���� �ý���==\n1. �ű� ȸ�� ���\n2. ȸ�� ���� ���\n0. ����\n>>");
			while(true) {
				try {
					menu = Integer.parseInt(sc.nextLine());
					break;
				} catch(Exception e) {
					System.out.println("���ڸ� �Է����ּ���.");
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
				System.out.println("�ý����� �����մϴ�."); 
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
				continue;
			}
		}
	}
}
