package exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
			Statement stat = con.createStatement();
//			String sql = "SELECT * FROM CAFE";
			String sql = "SELECT * FROM DEPARTMENT";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
//				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				System.out.printf("| %s |%-7s\t| %s |\n",rs.getString(1),rs.getString(2),rs.getString(3));
			}
//			while (rs.next()) {
//				System.out.printf("%d\t%15s\t%d\t%s\n",rs.getInt("ID"),rs.getString(2),rs.getInt(3),rs.getString(4));
//			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("¿¡·¯");
			e.printStackTrace();
		}
	}

}
