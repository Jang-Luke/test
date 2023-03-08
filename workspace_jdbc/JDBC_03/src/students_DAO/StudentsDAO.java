package students_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import students_DTO.StudentsDTO;

public class StudentsDAO {

	// try - catch : ���� �ڵ� ������ �ϳ� �̻��� ���ܰ� �߻��ϰ�, �̸� ��� �Ѱ��� �������� ó���� ���
	// try - catch, catch, catch ... : ���� �ڵ� ������ �پ��� �����l ���ܰ� �߻��ϰ�, �̸� �� ���ε��� ó���ؾ� �� ���
	// try - finally : ���� �ڵ带 �Ϸ��ϰų� ���ܰ� �߻����� ��, �ݵ�� (������) ����Ǿ�� �� �ڵ尡 �ִ� ���
	// try - catch - finally :
	// try - with resources : close�� �ʿ��� �ڿ��� ����ϴ� ���, ���A������ �ڿ��� close �ϴ� �� ������ ����
	// AutoCloseable Ŭ������ ��ӹ��� Ŭ������ ���Ͽ� ���� ����

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
	}

	public int insert(StudentsDTO dto) throws Exception {
		try (Connection con = getConnection();
			 PreparedStatement pstat = con.prepareStatement("INSERT INTO STUDENTS VALUES (STUDENTS_SEQ.NEXTVAL, ?, ?, ?, ?)");){
			pstat.setString(1, dto.getName());
			pstat.setInt(2, dto.getKor());
			pstat.setInt(3, dto.getEng());
			pstat.setInt(4, dto.getMath());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int insert2(StudentsDTO dto) throws Exception {
		try (Connection con = this.getConnection();
			 PreparedStatement pstat = 
			 con.prepareStatement("INSERT INTO STUDENTS VALUES (STUDENTS_SEQ.NEXTVAL, ?, ?, ?, ?)")) {
			pstat.setString(1, dto.getName());
			pstat.setInt(2, dto.getKor());
			pstat.setInt(3, dto.getEng());
			pstat.setInt(4, dto.getMath());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<StudentsDTO> showAllStudents() throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			 PreparedStatement pstat = con.prepareStatement("SELECT * FROM STUDENTS");
			 ResultSet rs = pstat.executeQuery();) {
			List<StudentsDTO> std = new ArrayList<>();
			while (rs.next()) {
				std.add(new StudentsDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
			return std;
		}
	}

	public List<StudentsDTO> searchStudentByName(String name) throws Exception {
		try (Connection con = this.getConnection();
			 PreparedStatement pstat = forSearchingByName(con, name);
			 ResultSet rs = pstat.executeQuery();) {
		List<StudentsDTO> std = new ArrayList<>();
		while (rs.next()) {
			std.add(new StudentsDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
		}
		return std;
		}
	}

	private PreparedStatement forSearchingByName(Connection con, String name) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENTS WHERE NAME LIKE ?");
		ps.setString(1, "%"+name+"%");
		return ps;
	}
	
	public int updateStudentByID(StudentsDTO dto) throws Exception {
		try(Connection con = getConnection();
			PreparedStatement pstat = 
			con.prepareStatement("UPDATE STUDENTS SET NAME = ?, KOR = ?, ENG = ?, MATH = ? WHERE ID = ?");) {
		pstat.setString(1, dto.getName());
		pstat.setInt(2, dto.getKor());
		pstat.setInt(3, dto.getEng());
		pstat.setInt(4, dto.getMath());
		pstat.setInt(5, dto.getId());
		int result = pstat.executeUpdate();
		con.commit();
		return result;
		}
	}

	public int deleteStudentByID(int id) throws Exception {
		try (Connection con = getConnection();
			 PreparedStatement pstat = con.prepareStatement("DELETE FROM STUDENTS WHERE ID = ?");) {
		pstat.setInt(1, id);
		int result = pstat.executeUpdate();
		con.commit();
		return result;
		}
	}

	public boolean isIDExist(int id) throws Exception {
		try (Connection con = getConnection();
			 PreparedStatement pstat = con.prepareStatement("SELECT * FROM STUDENTS WHERE ID = ?");){
		pstat.setInt(1, id);
		boolean result = pstat.executeQuery().next();
		return result;
		}
	}
}
