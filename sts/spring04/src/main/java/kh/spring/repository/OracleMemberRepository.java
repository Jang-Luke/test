package kh.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
		System.out.println(result);
		return result;
	}
	
}
