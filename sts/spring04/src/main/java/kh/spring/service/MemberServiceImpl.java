package kh.spring.service;

import org.springframework.stereotype.Service;

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
	
}
