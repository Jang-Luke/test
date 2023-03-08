package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("접속실패");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		try {
			Connection con = DriverManager.getConnection(url, id, pw);
			Statement stat = con.createStatement();
			String sql = "UPDATE CAFE SET NAME = 'Cafe Latte' WHERE NAME = 'Latte'";
			int result = stat.executeUpdate(sql);
			if (result > 0) {
				System.out.println(result + "행 성공");
			} else {
				System.out.println("0");
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
	}

}
