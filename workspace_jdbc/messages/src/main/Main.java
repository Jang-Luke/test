package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import commons.EncryptionUtils;
import dataAccessObject.MembersDAO;
import dataAccessObject.MessagesDAO;
import dataTransferObject.MembersDTO;
import dataTransferObject.MessagesDTO;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		MembersDAO memDAO = new MembersDAO();
		MessagesDAO masDAO = new MessagesDAO();
		MembersDTO loginCheck = new MembersDTO();
		MembersDTO myInfo = new MembersDTO();
		boolean flag = false;
		try {
			int menu;
			title: while (true) {
				System.out.println("<< 경량 게시판 프로젝트 >>");
				System.out.printf("1. 로그인\n2. 회원가입\n0. 종료\n>>>");
				menu = inputInt();
				if (menu < 0 || menu > 2) {
					System.out.println("메뉴를 다시 입력해주세요.");
					continue title;
				}
				if (menu == 1) {
					System.out.print("ID를 입력하세요 : ");
					String id = inputString();
					System.out.print("PW를 입력하세요 : ");
					String pw = EncryptionUtils.getSHA256(EncryptionUtils.getSHA256(inputString()));
					loginCheck = new MembersDTO(id, pw, null, null, null);
					if (memDAO.isLogined(loginCheck)) {
						flag = true;
						myInfo = memDAO.becomeMyInfo(loginCheck);
						loading();
						System.out.println("로그인 성공!!");
					}
				} else if (menu == 2) {
					System.out.print("ID를 입력하세요 : ");
					String id = inputString();
					if (memDAO.isIDExcist(id)) {
						System.out.println("중복된 아이디입니다.");
						continue title;
					}
					System.out.print("PW를 입력하세요 : ");
					String pw = EncryptionUtils.getSHA256(EncryptionUtils.getSHA256(inputString()));
					System.out.print("이름을 입력하세요 : ");
					String name = inputString();
					System.out.print("연락처를 입력하세요 : ");
					String contact = inputString();
					System.out.println(
							memDAO.signIn(new MembersDTO(id, pw, name, contact, null)) > 0 ? "가입 완료" : "가입 실패");
				} else if (menu == 0) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}
				main: while (flag) {
					System.out.println("<< KH 광장에 오신 것을 환영합니다. >>");
					System.out.printf("1. 신규 메세지 등록\n2. 메세지 목록 출력\n3. 메세지 삭제\n4. 메세지 수정\n"
							+ "5. 메세지 검색\n6. 내 정보 보기\n7. 로그아웃\n0. 시스템 종료\n>>>");
					menu = inputInt();
					if (menu < 0 || menu > 7) {
						System.out.println("메뉴를 다시 확인해주세요.");
						continue main;
					}
					if (menu == 1) {
						System.out.println("메세지를 자유롭게 입력해주세요.");
						String msg = inputString();
						System.out.println(masDAO.insertMsg(myInfo, msg) > 0 ? "입력 완료" : "입력 실패");
					} else if (menu == 2) {
						printMsg();
					} else if (menu == 3) {
						System.out.print("삭제하실 글 번호를 입력해주세요 : ");
						int msgNo = inputInt();
						System.out.println(masDAO.deleteMsg(msgNo) > 0 ? "삭제 완료" : "삭제 실패");
					} else if (menu == 4) {
						System.out.print("수정하실 글 번호를 입력해주세요 : ");
						int msgNo = inputInt();
						if (!masDAO.isMsgExist(msgNo)) {
							System.out.println("글 번호를 찾을 수 없습니다.");
							continue main;
						}
						System.out.println("수정하실 메세지를 입력해주세요.");
						String inputMsg = inputString();
						System.out.println("수정하실 시간대를 입력해주세요.");
						System.out.println("--년 --월 --일 --시 --분 총 10자리 (- 또는 / 또는 : 구분 없이 입력해주세요.)");
						String inputTime = inputString();
						System.out.println(masDAO.updateMsg(msgNo, inputMsg, inputTime) > 0 ? "수정 완료" : "수정 실패");
					} else if (menu == 5) {
						System.out.print("검색하실 단어를 입력해주세요 : ");
						String keyWord = inputString();
						printMsg(keyWord);
					} else if (menu == 6) {
						System.out.printf("|%-6s|%-5s|%-8s|%-10s|\n", "아이디", "이름", "연락처", "가입일");
						System.out.printf("|%-6s|%-5s|%-8s|%-10s|\n", myInfo.getId(), myInfo.getName(),
								myInfo.getContact(), myInfo.getFormedDate());
					} else if (menu == 7) {
						System.out.println("로그아웃 합니다.");
						flag = false;
						continue title;
					} else if (menu == 0) {
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}

	static int inputInt() {
		while (true) {
			try  {
				return Integer.parseInt(br.readLine());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("숫자를 입력해주세요.");
				continue;
			}
		}
	}

	static String inputString() {
		while (true) {
			try {
				return br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("올바른 문자를 입력해주세요.");
				continue;
			}
		}
	}

	static void printMsg() throws Exception {
		MessagesDAO masDAO = new MessagesDAO();
		List<MessagesDTO> allList = masDAO.showAll();

		allList.stream().forEach(e -> {
			System.out.printf("|%s\t|%s\t\t|\t\t%s\n", "글번호", "작성자", "작성일");
			System.out.printf("|%s\t|%s\t\t|\t\t%s\n----------------------------------------------------\n%s\n", e.getId(), e.getWriter(), e.getFormedDate(), e.getMessage());
			System.out.print("====================================================\n");
		});
	}

	static void printMsg(String keyWord) throws Exception {
		MessagesDAO masDAO = new MessagesDAO();
		List<MessagesDTO> allList = masDAO.searchByKeyWord(keyWord);
		allList.stream().forEach(e -> {
			System.out.printf("|%s\t|%s\t\t|\t\t%s\n", "글번호", "작성자", "작성일");
			System.out.print("----------------------------------------------------\n");
			System.out.printf("|%s\t|%s\t\t|\t\t%s\n----------------------------------------------------\n%s\n", e.getId(), e.getWriter(), e.getFormedDate(), e.getMessage());
			System.out.print("====================================================\n");
		});
	}

	public static void loading() throws Exception {
		System.out.print("불러오는 중.");
		Thread.sleep(100);
		System.out.print(".");
		Thread.sleep(100);
		System.out.print(".");
		Thread.sleep(100);
		System.out.print(".");
		Thread.sleep(100);
		System.out.print(".");
		Thread.sleep(100);
		System.out.print(".");
		Thread.sleep(100);
	}
}
