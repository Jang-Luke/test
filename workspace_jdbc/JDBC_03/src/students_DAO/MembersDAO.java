package students_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import students_DTO.MembersDTO;

public class MembersDAO {

//	public Connection getConnection() throws Exception {
//		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
//	}
	BasicDataSource bds = new BasicDataSource();

	public MembersDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(8);
	}
	
	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}
	// Library �� ������ (Dependencies)

	public List<MembersDTO> showAll() throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement("SELECT * FROM MEMBERS");
				ResultSet rs = pstat.executeQuery()) {
			List<MembersDTO> selectAll = new ArrayList<MembersDTO>();
			while (rs.next()) {
				selectAll.add(new MembersDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5)));
			}
			return selectAll;
		}
	}

	public boolean isIDExist(String id) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstat = forSearchingID(con, id);
				ResultSet rs = pstat.executeQuery();) {
			return rs.next();
		}
	}

	private PreparedStatement forSearchingID(Connection con, String id) throws SQLException {
		PreparedStatement pstat = con.prepareStatement("SELECT * FROM MEMBERS WHERE ID = ?");
		pstat.setString(1, id);
		return pstat;
	}

	public int sign(MembersDTO memDTO) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstat = con
						.prepareStatement("INSERT INTO MEMBERS (ID, PW, NAME, CONTACT) VALUES (?, ?, ?, ?)");) {
			pstat.setString(1, memDTO.getId());
			pstat.setString(2, memDTO.getPw());
			pstat.setString(3, memDTO.getName());
			pstat.setString(4, memDTO.getContact());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public boolean login(String id, String pw) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstat = forSearchingID(con, id);
				ResultSet rs = pstat.executeQuery();) {
			rs.next();
			return pw.equals(rs.getString(2));
		}
	}

	public boolean loadFirst() throws Exception {
		try (Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement("SELECT * FROM MEMBERS");
				ResultSet rs = pstat.executeQuery();) {
			return rs.next();
		}
	}

}
