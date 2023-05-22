package kh.study.khspring.repository;

import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.dto.Member;

import java.sql.SQLException;

public interface MemberRepository {

    boolean isMember(String username);

    void save(Member member) throws SQLException;

    LoginResponse findByUsername(LoginDto loginDto);
}
