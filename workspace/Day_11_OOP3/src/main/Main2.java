package main;

import java.util.Scanner;

import manager.*;

public class Main2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// 상속
		// 추상화
		// Collection
		// 배열 문제를 해결하기 위한 첫 번째 대안
		// 1. 동적 배열 - Vector -> ArrayList (순차적 데이터 입력에 강점이 있음, 비순차적 데이터 삭제에 약함)
		// 2. LinkedList (비순차적 데이터 삭제에 강점이 있음, ArrayList에 비해 데이터 입력 속도가 다소 느림)
		// 3. Hash , Tree

		// 회원관리 시스템
		// 등급 클래스 설계 (Silver)
		// 회원 아이디
		// 회원 이름
		// 회원 포인트
		// Getter / Setter / Constructor / Default Constructor / 정보은닉

		// 완성된 코드의 문제점 3가지
		// 코드 중복도 ( 유지 보수 문제점 ) - 상속 [ IS - A 관계 ] << 해결 >>
		// 코드 결합도 ( 유지 보수 문제점 ) - 다형성 << 해결 >>
		// 저장소 - Collection
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
