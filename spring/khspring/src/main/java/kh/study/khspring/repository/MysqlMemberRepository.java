package kh.study.khspring.repository;

import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MysqlMemberRepository implements MemberRepository {

    private JdbcTemplate jdbcTemplate;

    public MysqlMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isMember(String username) {
        String sql = "select count(*) from members where username = ?";
        Boolean result = jdbcTemplate.queryForObject(sql, Boolean.class, username);
        return result;
    }

    @Override
    public void save(Member member) throws SQLException {
        String sql = "insert into members values(0, ?, ?, ?, ?, ?, ?, ?, ?, default)";
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
    public LoginResponse findByUsername(LoginDto loginDto) {
        String sql = "select username, password from members where username = ?";
        LoginResponse loginResponse = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return new LoginResponse(rs.getString("username"), rs.getString("password"));
        }, loginDto.getUsername());
        return loginResponse;
    }
}
