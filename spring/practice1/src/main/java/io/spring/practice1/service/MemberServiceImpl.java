package io.spring.practice1.service;

import io.spring.practice1.dto.JoinRequest;
import io.spring.practice1.entity.Member;
import io.spring.practice1.entity.Profile;
import io.spring.practice1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncryptor passwordEncryptor;

    @Override
    public Member join(JoinRequest joinRequest) {
        Member member = Member.builder()
            .username(joinRequest.getUsername())
            .password(passwordEncryptor.encryptPassword(joinRequest.getPassword()))
            .build();

        Profile profile = Profile.builder()
            .name(joinRequest.getName())
            .phone(joinRequest.getPhone())
            .email(joinRequest.getEmail())
            .address(joinRequest.getAddress())
            .build();
        return memberRepository.save(member);
    }
}
