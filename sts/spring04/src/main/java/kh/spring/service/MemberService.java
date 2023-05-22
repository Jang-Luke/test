package kh.spring.service;

import kh.spring.dto.LoginDto;
import kh.spring.dto.Member;

public interface MemberService {
	boolean isMember(String username);

	void save(Member member);

	boolean login(LoginDto loginDto);
}
