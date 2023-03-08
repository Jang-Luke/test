package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// JDBC : Java Database Connectivity
		// Java 프로그램에서 DBMS를 사용하기 위한 라이브러리 및 문법
		// OJDBC JAR
		System.out.println("JDBC : Java Database Connectivity");
		System.out.println("Java 프로그램에서 DBMS를 사용하기 위한 라이브러리 및 문법");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("라이브러리를 찾을 수 없습니다.");
			System.exit(0);
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		while (true) {
			try {
				Connection con = DriverManager.getConnection(url, dbID, dbPW);
				System.out.println("연결성공");
				String sql = "INSERT INTO CAFE VALUES (CAFE_SEQ.NEXTVAL, ?, ?, ?)";
				PreparedStatement pstat = con.prepareStatement(sql);

				System.out.print("신규 등록할 메뉴의 이름 : ");
				pstat.setString(1, inputOnlyString());
				System.out.print("신규 등록할 메뉴의 가격 : ");
				pstat.setInt(2, inputInt());
				System.out.print("신규 등록할 메뉴는 아이스인가요? : ");
				pstat.setString(3, inputOnlyString());

				int result = pstat.executeUpdate();
				if (result > 0) {
					System.out.println("입력 성공");
				} else {
					System.out.println("입력 실패");
				}
				con.commit();
				pstat.close();
				con.close();
			} catch (Exception e) {
				System.out.println("데이터베이스 연결 실패");
				e.printStackTrace();
			}
		}
	}

	static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("숫자를 다시 입력해주세요.");
			}
		}
	}

	static String inputOnlyString() {
		while (true) {
			try {
				String s = sc.nextLine();
				if (s.matches("^\\d*$")) {
					System.out.println("문자를 입력해주세요.");
					continue;
				} else {
					return s;
				}
			} catch (Exception e) {
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}