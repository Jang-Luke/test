package kh.study.khspring.service;


import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.entity.Member;

public interface MemberService {
    boolean isMember(String username);

    void save(Member member);

    String login(LoginDto loginDto);
}
