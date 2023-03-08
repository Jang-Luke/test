package quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		ResultSet rs;
		// employee ���̺��� ���, �����, �޿��� ������ ����ϴ� �ڵ带 �ۼ��ϼ���.
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			PreparedStatement pstat = con
					.prepareStatement("SELECT EMP_ID, EMP_NAME, TO_CHAR(SALARY,'L9G999G999') FROM EMPLOYEE");
			rs = pstat.executeQuery();
			int index = 1;
			System.out.println("|No | ��� | ����� |       �޿���       |");
			while (rs.next()) {
				System.out.printf("|%-3d| %d | %s |%10s|\n", index++, rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
}
