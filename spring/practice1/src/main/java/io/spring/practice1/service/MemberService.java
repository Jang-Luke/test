package io.spring.practice1.service;

import io.spring.practice1.dto.JoinRequest;
import io.spring.practice1.entity.Member;

public interface MemberService {
    Member join(JoinRequest joinRequest);
}
