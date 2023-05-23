package kh.study.khspring.service;

import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.dto.Member;
import kh.study.khspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean isMember(String username) {
        return memberRepository.isMember(username);
    }

    @Override
    public void save(Member member) {
        try {
            memberRepository.save(member);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public LoginResponse login(LoginDto loginDto) {
        return memberRepository.findByUsername(loginDto);
    }
}
