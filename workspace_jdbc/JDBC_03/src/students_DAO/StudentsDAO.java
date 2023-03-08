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

	// try - catch : 실행 코드 내에세 하나 이상의 예외가 발생하고, 이를 모두 한가지 로직으로 처리할 경우
	// try - catch, catch, catch ... : 실행 코드 내에서 다양한 종류릐 예외가 발생하고, 이를 다 따로따로 처리해야 할 경우
	// try - finally : 실행 코드를 완료하거나 예외가 발생했을 시, 반드시 (무조건) 실행되어야 할 코드가 있는 경우
	// try - catch - finally :
	// try - with resources : close가 필요한 자원을 사용하는 경우, 저랟적으로 자원을 close 하는 더 심플한 문법
	// AutoCloseable 클래스를 상속받은 클래스에 한하여 적용 가능

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
