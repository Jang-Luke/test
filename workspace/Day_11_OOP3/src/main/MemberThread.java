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
					"==회원 관리 시스템==\n1. 신규 회원 등록\n2. 회원 정보 출력\n3. 회원 정보 삭제\n4. 회원 정보 찾기\n5. 회원 정보 수정\n0. 종료\n>>");
			menu = inputInt();
			if (menu == 1) {
				System.out.printf("회원 번호를 입력해주세요.\n>>");
				int id = inputInt();
				System.out.printf("회원 등급을 입력해주세요.\n>>");
				String grade = inputString();
				if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				System.out.printf("회원 이름을 입력해주세요.\n>>");
				String name = inputString();
				System.out.printf("보너스 포인트를 입력해주세요.\n>>");
				double bonus = inputInt();
				manager.insert(grade, id, name, bonus);
				System.out.printf("새 회원 추가\n%d\t%s\t%s\t%.1f\n", id, grade, name, bonus);
			} else if (menu == 2) {
				System.out.printf("==메뉴 선택==\n1. 실버 회원\n2. 골드 회원\n3. 루비 회원\n4. 모든 회원\n5. 돌아가기\n>>");
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
				System.out.printf("1. 회원 번호로 삭제\n2. 회원 이름으로 삭제\n3. 돌아가기\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("회원 번호를 입력해주세요.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					manager.removeMemberByID(i);
				} else if (menu == 2) {
					System.out.printf("회원 이름을 입력해주세요.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					manager.removeMemberByName(s);
				} else if (menu == 3) {
					continue;
				}
			} else if (menu == 4) {
				System.out.printf("1. 회원 번호로 검색\n2. 회원 이름으로 검색\n3. 돌아가기\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("회원 번호를 입력해주세요.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					manager.printMember(manager.getMembersByID(i));
				} else if (menu == 2) {
					System.out.printf("회원 이름을 입력해주세요.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					manager.printMember(manager.getMembersByName(s));
				} else if (menu == 3) {
					continue;
				}
			} else if (menu == 5) {
				System.out.printf("1. 회원 번호로 검색하여 수정\n2. 회원 이름으로 검색하여 수정\n3. 돌아가기\n>>");
				menu = inputInt();
				if (menu == 1) {
					System.out.printf("회원 번호를 입력해주세요.\n>>");
					int i = inputInt();
					if (manager.getMembersByID(i).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					System.out.printf("수정할 회원 번호를 입력해주세요.\n>>");
					int id = inputInt();
					System.out.printf("수정할 회원 등급을 입력해주세요.\n>>");
					String grade = inputString();
					if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
						System.out.println("다시 입력해주세요.");
						continue;
					}
					System.out.printf("수정할 회원 이름을 입력해주세요.\n>>");
					String name = inputString();
					System.out.printf("보너스 포인트를 입력해주세요.\n>>");
					double bonus = inputDouble();
					manager.modifyMemberByID(i, grade, id, name, bonus);
				} else if (menu == 2) {
					System.out.printf("회원 이름을 입력해주세요.\n>>");
					String s = inputString();
					if (manager.getMembersByName(s).size() == 0) {
						System.out.println("회원이 존재하지 않습니다.");
						continue;
					}
					System.out.printf("수정할 회원 번호를 입력해주세요.\n>>");
					int id = inputInt();
					System.out.printf("수정할 회원 등급을 입력해주세요.\n>>");
					String grade = inputString();
					if ((grade.equals("Silver") || grade.equals("Gold") || grade.equals("Ruby")) == false) {
						System.out.println("다시 입력해주세요.");
						continue;
					}
					System.out.printf("수정할 회원 이름을 입력해주세요.\n>>");
					String name = inputString();
					System.out.printf("보너스 포인트를 입력해주세요.\n>>");
					double bonus = inputDouble();
					manager.modifyMemberByName(s, grade, id, name, bonus);
				} else if (menu == 3) {
					continue;
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

	static int inputInt() {
		Scanner sc = new Scanner(System.in);
		int input;
		while (true) {
			try {
				input = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
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
				System.out.println("숫자를 입력해주세요.");
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
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
		return input;
	}
}

