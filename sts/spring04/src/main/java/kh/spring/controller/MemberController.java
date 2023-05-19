package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/signup")
	public String toSignup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signup() {
		return "/";
	}
	
	@PostMapping("/login")
	public String login() {
		return "/";
	}
	
	@PostMapping(
			value = "/idCheck",
			produces = "text/html; charset=utf8"
			)
	@ResponseBody
	public String idCheck(String username) {
		boolean result = memberService.isMember(username);
		return String.valueOf(result);
	}
}