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
		// Java ���α׷����� DBMS�� ����ϱ� ���� ���̺귯�� �� ����
		// OJDBC JAR
		System.out.println("JDBC : Java Database Connectivity");
		System.out.println("Java ���α׷����� DBMS�� ����ϱ� ���� ���̺귯�� �� ����");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("���̺귯���� ã�� �� �����ϴ�.");
			System.exit(0);
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		while (true) {
			try {
				Connection con = DriverManager.getConnection(url, dbID, dbPW);
				System.out.println("���Ἲ��");
				String sql = "INSERT INTO CAFE VALUES (CAFE_SEQ.NEXTVAL, ?, ?, ?)";
				PreparedStatement pstat = con.prepareStatement(sql);

				System.out.print("�ű� ����� �޴��� �̸� : ");
				pstat.setString(1, inputOnlyString());
				System.out.print("�ű� ����� �޴��� ���� : ");
				pstat.setInt(2, inputInt());
				System.out.print("�ű� ����� �޴��� ���̽��ΰ���? : ");
				pstat.setString(3, inputOnlyString());

				int result = pstat.executeUpdate();
				if (result > 0) {
					System.out.println("�Է� ����");
				} else {
					System.out.println("�Է� ����");
				}
				con.commit();
				pstat.close();
				con.close();
			} catch (Exception e) {
				System.out.println("�����ͺ��̽� ���� ����");
				e.printStackTrace();
			}
		}
	}

	static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("���ڸ� �ٽ� �Է����ּ���.");
			}
		}
	}

	static String inputOnlyString() {
		while (true) {
			try {
				String s = sc.nextLine();
				if (s.matches("^\\d*$")) {
					System.out.println("���ڸ� �Է����ּ���.");
					continue;
				} else {
					return s;
				}
			} catch (Exception e) {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
}