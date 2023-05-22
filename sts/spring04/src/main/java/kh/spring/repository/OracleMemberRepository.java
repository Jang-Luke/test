package kh.spring.repository;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.LoginDto;
import kh.spring.dto.Member;

@Repository
public class OracleMemberRepository implements MemberRepository {

	private JdbcTemplate jdbcTemplate;

	public OracleMemberRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean isMember(String username) {
		String sql = "select count(*) from member_2 where username = ?";
		Boolean result = jdbcTemplate.queryForObject(sql, Boolean.class, username);
		return result;
	}

	@Override
	public void save(Member member) throws SQLException {
		String sql = "insert into member_2 values(members_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, default)";
		jdbcTemplate.update(sql,
				member.getUsername(),
				member.getPassword(),
				member.getName(),
				member.getPhone(),
				member.getEmail(),
				member.getZipcode(),
				member.getAddress1(),
				member.getAddress2());
	}

	@Override
	public boolean login(LoginDto loginDto) {
		String sql = "select count(*) from member_2 where username = ? and password = ?";
		Boolean result = jdbcTemplate.queryForObject(sql, Boolean.class, loginDto.getUsername(), loginDto.getPassword());
		return result; 
	}
	
}
