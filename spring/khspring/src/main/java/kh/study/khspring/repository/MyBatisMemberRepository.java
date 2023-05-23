package kh.study.khspring.repository;

import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.dto.Member;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public boolean isMember(String username) {
        return sqlSessionTemplate.selectOne("Members.isMember", username);
    }

    @Override
    public void save(Member member) throws SQLException {
        sqlSessionTemplate.insert("Members.insert", member);
    }

    @Override
    public LoginResponse findByUsername(LoginDto loginDto) {
        return sqlSessionTemplate.selectOne("Members.login", loginDto);
    }
}
