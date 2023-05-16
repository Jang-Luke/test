package com.example.spring_exam.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
