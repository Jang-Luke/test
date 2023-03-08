package quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		ResultSet rs;
		// employee 테이블에서 사번, 사원명, 급여를 가져와 출력하는 코드를 작성하세요.
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			PreparedStatement pstat = con
					.prepareStatement("SELECT EMP_ID, EMP_NAME, TO_CHAR(SALARY,'L9G999G999') FROM EMPLOYEE");
			rs = pstat.executeQuery();
			int index = 1;
			System.out.println("|No | 사번 | 사원명 |       급여임       |");
			while (rs.next()) {
				System.out.printf("|%-3d| %d | %s |%10s|\n", index++, rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
	}
}
