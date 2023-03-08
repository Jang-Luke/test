package main;

import java.util.Scanner;

import manager.Manager2;

public class MemberThread extends Thread {
	
	public void run() {
		Manager2 manager = new Manager2();
		int a = 1 + 1;
		int menu;
		manager.insert("Silver", 1001, "Tom", 1000);
		manager.insert("Silver", 1002, "Jane", 2000);
		manager.insert("Silver", 1003, "Mike", 3000);
		manager.insert("Gold", 1004, "Susan", 4000);
		manager.insert("Ruby", 1005, "Jack", 5000);
		while (true) {
			System.out.printf(
					"==ȸ�� ���� �ý���==\n1. �ű� ȸ�� ���\n2. ȸ�� ���� ���\n3. ȸ�� ���� ����\n4. ȸ�� ���� ã��\n5. ȸ�� ���� ����\n0. ����\n>>");
			menu = inputInt();
			if (menu == 1) {
				System.out.printf("ȸ�� ��ȣ�� �Է����ּ���.\n>>");
				int id = inputInt();
				System.out.printf("ȸ�� ����� �Է����ּ���.\n>>");
				String grade = inputString();
				if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
					System.out.println("�ٽ� �Է����ּ���.");
					continue;
				}
				System.out.printf("ȸ�� �̸��� �Է����ּ���.\n>>");
				String name = inputString();
				System.out.printf("���ʽ� ����Ʈ�� �Է����ּ���.\n>>");
				double bonus = inputInt();
				manager.insert(grade, id, name, bonus);
				System.out.printf("�� ȸ�� �߰�\n%d\t%s\t%s\t%.1f\n", id, grade, name, bonus);
			} else if (menu == 2) {
				System.out.printf("==�޴� ����==\n1. �ǹ� ȸ��\n2. ��� ȸ��\n3. ��� ȸ��\n4. ��� ȸ��\n5. ���ư���\n>>");
				menu = inputInt();
				if (menu == 1) {
					manager.showMemberInfo("Silver");
				} else if (menu == 2) {
					manager.showMemberInfo("Gold");
				} else if (menu == 3) {
					manager.showMemberInfo("Ruby");
				} else if (menu == 4) {
					manager.showMemberInfo("All");
				} else if (menu == 5) {
					continue;
				}
			} else if (menu == 3) {
				System.out.printf("1. ȸ�� ��ȣ�� ����\n2. ȸ�� �̸����� ����\n3. ���ư���\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("ȸ�� ��ȣ�� �Է����ּ���.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					manager.removeMemberByID(i);
				} else if (menu == 2) {
					System.out.printf("ȸ�� �̸��� �Է����ּ���.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					manager.removeMemberByName(s);
				} else if (menu == 3) {
					continue;
				}
			} else if (menu == 4) {
				System.out.printf("1. ȸ�� ��ȣ�� �˻�\n2. ȸ�� �̸����� �˻�\n3. ���ư���\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("ȸ�� ��ȣ�� �Է����ּ���.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					manager.printMember(manager.getMembersByID(i));
				} else if (menu == 2) {
					System.out.printf("ȸ�� �̸��� �Է����ּ���.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					manager.printMember(manager.getMembersByName(s));
				} else if (menu == 3) {
					continue;
				}
			} else if (menu == 5) {
				System.out.printf("1. ȸ�� ��ȣ�� �˻��Ͽ� ����\n2. ȸ�� �̸����� �˻��Ͽ� ����\n3. ���ư���\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("ȸ�� ��ȣ�� �Է����ּ���.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					System.out.printf("������ ȸ�� ��ȣ�� �Է����ּ���.\n>>");
					int id = inputInt();
					System.out.printf("������ ȸ�� ����� �Է����ּ���.\n>>");
					String grade = inputString();
					if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
						System.out.println("�ٽ� �Է����ּ���.");
						continue;
					}
					System.out.printf("������ ȸ�� �̸��� �Է����ּ���.\n>>");
					String name = inputString();
					System.out.printf("���ʽ� ����Ʈ�� �Է����ּ���.\n>>");
					double bonus = inputDouble();
					manager.modifyMemberByID(i, grade, id, name, bonus);
				} else if (menu == 2) {
					System.out.printf("ȸ�� �̸��� �Է����ּ���.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("ȸ���� �������� �ʽ��ϴ�.");
						continue;
					}
					System.out.printf("������ ȸ�� ��ȣ�� �Է����ּ���.\n>>");
					int id = inputInt();
					System.out.printf("������ ȸ�� ����� �Է����ּ���.\n>>");
					String grade = inputString();
					if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
						System.out.println("�ٽ� �Է����ּ���.");
						continue;
					}
					System.out.printf("������ ȸ�� �̸��� �Է����ּ���.\n>>");
					String name = inputString();
					System.out.printf("���ʽ� ����Ʈ�� �Է����ּ���.\n>>");
					double bonus = inputDouble();
					manager.modifyMemberByName(s, grade, id, name, bonus);
				} else if (menu == 3) {
					continue;
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

	static int inputInt() {
		Scanner sc = new Scanner(System.in);
		int input;
		while (true) {
			try {
				input = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
		return input;
	}

	static double inputDouble() {
		Scanner sc = new Scanner(System.in);
		double input;
		while (true) {
			try {
				input = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
		return input;
	}

	static String inputString() {
		Scanner sc = new Scanner(System.in);
		String input;
		while (true) {
			try {
				input = sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
		}
		return input;
	}
}

