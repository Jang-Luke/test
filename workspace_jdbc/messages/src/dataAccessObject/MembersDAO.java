package dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

import dataTransferObject.MembersDTO;

public class MembersDAO {
	
	BasicDataSource bds = new BasicDataSource();
	public MembersDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("BOARD");
		bds.setPassword("BOARD");
		bds.setInitialSize(8);
	}
	
	public Connection getConnection() throws Exception {
		return bds.getConnection();
	}
	
	public int signIn(MembersDTO mdto) throws Exception {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO MEMBERS (ID, PW, NAME, CONTACT) VALUES (?, ?, ?, ?)");
			) {
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			ps.setString(3, mdto.getName());
			ps.setString(4, mdto.getContact());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}
		
	}
	
	public boolean isLogined(MembersDTO mdto) throws Exception {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?");) {
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			try(ResultSet rs = ps.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public boolean isIDExcist(String id) throws Exception {
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM MEMBERS WHERE ID = ?");) {
			ps.setString(1, id);
			try(ResultSet rs = ps.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public MembersDTO becomeMyInfo(MembersDTO mdto) throws Exception {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?");) {
				ps.setString(1, mdto.getId());
				ps.setString(2, mdto.getPw());
				try(ResultSet rs = ps.executeQuery()){
					rs.next();
					return new MembersDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
				}
			}
	}
}
