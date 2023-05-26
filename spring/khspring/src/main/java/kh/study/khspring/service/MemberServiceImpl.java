package kh.study.khspring.service;

import kh.study.khspring.dto.Encryptable;
import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.entity.Member;
import kh.study.khspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncryptor passwordEncryptor;

    @Override
    public boolean isMember(String username) {
        return memberRepository.isMember(username);
    }

    @Override
    public void save(Member member) {
        try {
            encryptPassword(member);
            memberRepository.save(member);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String login(LoginDto loginDto) {
        LoginResponse loginResponse = memberRepository.findByUsername(loginDto);
        if (passwordEncryptor.checkPassword(loginDto.getPassword(), loginResponse.getPassword())) {
            return loginDto.getUsername();
        } else {
            throw new RuntimeException();
        }
    }


    private void encryptPassword(Encryptable type) {
        String plainPassword = type.getPassword();
        String encryptedPassword = passwordEncryptor.encryptPassword(plainPassword);
        type.setPassword(encryptedPassword);
    }
}
