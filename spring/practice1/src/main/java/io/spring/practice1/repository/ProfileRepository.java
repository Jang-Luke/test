package io.spring.practice1.repository;

import io.spring.practice1.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Override
    Profile save(Profile profile);
    //TODO : 회원가입 기능 구현하기
}
