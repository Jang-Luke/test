package kh.spring.repository;

import java.sql.SQLException;

import kh.spring.dto.LoginDto;
import kh.spring.dto.Member;

public interface MemberRepository {

	boolean isMember(String username);

	void save(Member member) throws SQLException;

	boolean login(LoginDto loginDto);
}
