package kh.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OracleBoardRepository implements BoardRepository {
	private JdbcTemplate jdbcTemplate;
	
	public OracleBoardRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
