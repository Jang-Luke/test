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
			System.out.println("���ӽ���");
		}
		String id = "kh";
		String pw = "kh";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = "DELETE FROM CAFE WHERE NAME = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			System.out.print("������ �޴� �̸��� �Է����ּ��� : ");
			pstat.setString(1, sc.nextLine());
			if (pstat.executeUpdate() != 0) {
				System.out.println("����");
			} else {
				System.out.println("����");
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println("����");
			e.printStackTrace();
		}
	}

}
