package main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import dto.MoviesDTO;
import manager.MoviesDAO;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Netflix ��ȭ ���� ���α׷�
		// ���̺� ���� : MOVIES
		// ID - 1001 ~ ���� 1�� �����ϴ� �� Ű
		// TITLE - ���ڿ� �ִ� 50byte ����
		// GENRE - ���ڿ� 20byte
		// ��� not null
		// ID�� �������� ��� ���� ���� / ����
		
		while (true) {
			try {
				System.out.printf(
						"<< Netflix ��ȭ ���� ���α׷� >>\n1. �ű� ��ȭ ���\n2. ��ȭ ��� ���\n3. ��ȭ ���� ����\n4. ��ȭ ���� ����\n5. ��ȭ ���� �˻�\n0. ����\n>>>");
				int menu = inputInt();
				if (menu < 0 || menu > 5) {
					System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
					continue;
				} else if (menu == 1) {
					System.out.print("��� �Ͻ� ��ȭ�� �̸��� �Է����ּ��� : ");
					String title = inputString();
					System.out.print("��� �Ͻ� ��ȭ�� �帣�� �Է����ּ��� : ");
					String genre = inputOnlyString();
					MoviesDAO m = new MoviesDAO();
					MoviesDTO dto = new MoviesDTO(0, title, genre);
					System.out.println(m.insertMovies(dto) > 0 ? "�Է� �Ϸ�" : "�Է� ����");
				} else if (menu == 2) {
					if (showMovies() == false) {
						continue;
					}
				} else if (menu == 3) {
					if (showMovies() == false) {
						continue;
					}
					System.out.print("���� �Ͻ� ��ȭ�� ID�� �Է����ּ��� : ");
					int id = inputInt();
					MoviesDAO m = new MoviesDAO();
					if (!m.isIDExist(id)) { // �ش� ID�� ��� false�� ��ȯ�Ǿ��� ��, !(not) ��ȣ�� �������� true�� ����� If�� ����
						System.out.println("ID : [" + id + "] ��ȭ�� ã�� �� �����ϴ�.");
						continue;
					}
					System.out.print("���� �Ͻ� ��ȭ�� ������ �Է����ּ��� : ");
					String title = inputString();
					System.out.print("���� �Ͻ� ��ȭ�� �帣�� �Է����ּ��� : ");
					String genre = inputOnlyString();
					MoviesDTO dto = new MoviesDTO(id, title, genre);
					MoviesDAO m2 = new MoviesDAO();
					System.out.println(m2.updateMovie(dto) > 0 ? "���� �Ϸ�" : "���� ����");
				} else if (menu == 4) {
					if (showMovies() == false) {
						continue;
					}
					System.out.print("���� �Ͻ� ��ȭ�� ID�� �Է����ּ��� : ");
					int id = inputInt();
					MoviesDAO m = new MoviesDAO();
					System.out.println(m.deleteMovie(id) > 0 ? "���� �Ϸ�" : "���� ����");
				} else if (menu == 5) {
					System.out.print("�˻��Ͻ� ��ȭ�� ������ �Է����ּ��� : ");
					String title = inputString();
					showMovies(title);
				} else if (menu == 0) {
					System.out.println("���� ����");
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
				System.out.println("���ڸ� �Է����ּ���.");
			}
		}
	}

	static String inputOnlyString() {
		while (true) {
			String s = sc.nextLine();
			
			if (!s.matches("^\\d*$")) {
				return s;
			} else {
				System.out.println("���ڸ� �Է��� �� �����ϴ�.");
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
			System.out.println("������ �߻��Ͽ����ϴ�.");
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
			System.out.println("������ �߻��Ͽ����ϴ�.");
			return false;
		}
	}
}
