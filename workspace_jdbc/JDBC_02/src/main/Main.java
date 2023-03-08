package main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import dto.MoviesDTO;
import manager.MoviesDAO;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Netflix 영화 관리 프로그램
		// 테이블 설계 : MOVIES
		// ID - 1001 ~ 무한 1씩 증가하는 주 키
		// TITLE - 문자열 최대 50byte 까지
		// GENRE - 문자열 20byte
		// 모두 not null
		// ID를 기준으로 모든 정보 수정 / 삭제
		
		while (true) {
			try {
				System.out.printf(
						"<< Netflix 영화 관리 프로그램 >>\n1. 신규 영화 등록\n2. 영화 목록 출력\n3. 영화 정보 수정\n4. 영화 정보 삭제\n5. 영화 정보 검색\n0. 종료\n>>>");
				int menu = inputInt();
				if (menu < 0 || menu > 5) {
					System.out.println("메뉴를 다시 확인해주세요.");
					continue;
				} else if (menu == 1) {
					System.out.print("등록 하실 영화의 이름을 입력해주세요 : ");
					String title = inputString();
					System.out.print("등록 하실 영화의 장르를 입력해주세요 : ");
					String genre = inputOnlyString();
					MoviesDAO m = new MoviesDAO();
					MoviesDTO dto = new MoviesDTO(0, title, genre);
					System.out.println(m.insertMovies(dto) > 0 ? "입력 완료" : "입력 실패");
				} else if (menu == 2) {
					if (showMovies() == false) {
						continue;
					}
				} else if (menu == 3) {
					if (showMovies() == false) {
						continue;
					}
					System.out.print("수정 하실 영화의 ID를 입력해주세요 : ");
					int id = inputInt();
					MoviesDAO m = new MoviesDAO();
					if (!m.isIDExist(id)) { // 해당 ID가 없어서 false가 반환되었을 때, !(not) 기호로 반전시켜 true를 만들고 If문 실행
						System.out.println("ID : [" + id + "] 영화를 찾을 수 없습니다.");
						continue;
					}
					System.out.print("수정 하실 영화의 제목을 입력해주세요 : ");
					String title = inputString();
					System.out.print("수정 하실 영화의 장르를 입력해주세요 : ");
					String genre = inputOnlyString();
					MoviesDTO dto = new MoviesDTO(id, title, genre);
					MoviesDAO m2 = new MoviesDAO();
					System.out.println(m2.updateMovie(dto) > 0 ? "수정 완료" : "수정 실패");
				} else if (menu == 4) {
					if (showMovies() == false) {
						continue;
					}
					System.out.print("삭제 하실 영화의 ID를 입력해주세요 : ");
					int id = inputInt();
					MoviesDAO m = new MoviesDAO();
					System.out.println(m.deleteMovie(id) > 0 ? "삭제 완료" : "삭제 실패");
				} else if (menu == 5) {
					System.out.print("검색하실 영화의 제목을 입력해주세요 : ");
					String title = inputString();
					showMovies(title);
				} else if (menu == 0) {
					System.out.println("접속 종료");
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
	}

	static String inputOnlyString() {
		while (true) {
			String s = sc.nextLine();
			
			if (!s.matches("^\\d*$")) {
				return s;
			} else {
				System.out.println("숫자를 입력할 수 없습니다.");
				continue;
			}
		}
	}

	static String inputString() {
		return sc.nextLine();
	}

	static boolean showMovies() {
		try {
			System.out.println("=========================================");
			System.out.printf("|%-6s|%-8s\t|%-7s\t|\n", "ID", "Title", "Genre");
			System.out.println("=========================================");
			MoviesDAO m = new MoviesDAO();
			List<MoviesDTO> show = m.showAllMovies();
			for (MoviesDTO mIns : show) {
				System.out.printf("|%-6d|%-8s\t|%-7s\t|\n", mIns.getId(), mIns.getTitle(), mIns.getGenre());
			}
			System.out.println("=========================================");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류가 발생하였습니다.");
			return false;
		}
	}

	static boolean showMovies(String title) {
		try {
			System.out.println("=========================================");
			System.out.printf("|%-6s|%-8s\t|%-7s\t|\n", "ID", "Title", "Genre");
			System.out.println("=========================================");
			MoviesDAO m = new MoviesDAO();
			List<MoviesDTO> show = m.searchByTitle(title);
			for (MoviesDTO mIns : show) {
				System.out.printf("|%-6d|%-8s\t|%-7s\t|\n", mIns.getId(), mIns.getTitle(), mIns.getGenre());
			}
			System.out.println("=========================================");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류가 발생하였습니다.");
			return false;
		}
	}
}
