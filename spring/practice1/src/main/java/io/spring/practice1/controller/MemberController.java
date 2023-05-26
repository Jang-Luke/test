package io.spring.practice1.controller;

import io.spring.practice1.dto.JoinRequest;
import io.spring.practice1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String toJoinForm() {
        return "member/joinForm";
    }

    @PostMapping("/add")
    public String join(@Validated @ModelAttribute JoinRequest joinRequest, BindingResult bindingResult) {
        log.info("join with {}", joinRequest);
        memberService.join(joinRequest);

        return "";
    }
}
