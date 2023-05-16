package com.example.spring_exam.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
