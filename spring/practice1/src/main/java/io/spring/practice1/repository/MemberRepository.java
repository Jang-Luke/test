package io.spring.practice1.repository;

import io.spring.practice1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Override
    Member save(Member member);

    @Override
    Optional<Member> findById(Long id);

    @Override
    void deleteById(Long id);
}
