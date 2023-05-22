package kh.spring.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import kh.spring.dto.LoginDto;
import kh.spring.dto.Member;
import kh.spring.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public boolean isMember(String username) {
		return memberRepository.isMember(username);
	}

	@Override
	public void save(Member member) {
		try{
			memberRepository.save(member);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean login(LoginDto loginDto) {
		return memberRepository.login(loginDto);
	}
	
}
