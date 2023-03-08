package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("접속실패");
		}
		String id = "kh";
		String pw = "kh";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = "DELETE FROM CAFE WHERE NAME = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			System.out.print("삭제할 메뉴 이름을 입력해주세요 : ");
			pstat.setString(1, sc.nextLine());
			if (pstat.executeUpdate() != 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}

}
