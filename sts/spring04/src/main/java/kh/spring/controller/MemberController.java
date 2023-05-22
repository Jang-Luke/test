package kh.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.Encryptable;
import kh.spring.dto.LoginDto;
import kh.spring.dto.Member;
import kh.spring.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	private MemberService memberService;
	private PasswordEncryptor passwordEncryptor;
	private HttpSession session;

	public MemberController(MemberService memberService, PasswordEncryptor passwordEncryptor, HttpSession session) {
		this.memberService = memberService;
		this.passwordEncryptor = passwordEncryptor;
		this.session = session;
	}

	@GetMapping("/signup")
	public String toSignup() {
		return "/members/signup";
	}
	
	@PostMapping("/signup")
	public String signup(Member member) {
		encryptPassword(member);
		memberService.save(member);
		return "rediection:/";
	}
	
	@PostMapping("/login")
	public String login(LoginDto loginDto, HttpServletResponse response) {
		if (loginDto.getRememberUsername()) {
			addUsernameToCookie(loginDto.getUsername(), response);
		}
		encryptPassword(loginDto);
		if (memberService.login(loginDto)) {
			session.setAttribute("loginId", loginDto.getUsername());
		} else {
			throw new RuntimeException();
		}
		return "redirection:/home";
	}


	
	@PostMapping(
			value = "/idCheck",
			produces = "text/html; charset=utf8"
			)
	@ResponseBody
	public String idDuplicationCheck(String username) {
		boolean result = memberService.isMember(username);
		return String.valueOf(result);
	}
	
	private void encryptPassword(Encryptable type) {
		String plainPassword = type.getPassword();
		String encryptedPassword = passwordEncryptor.encryptPassword(plainPassword);
		type.setPassword(encryptedPassword);
	}
	
	private void addUsernameToCookie(String username, HttpServletResponse response) {
		Cookie usernameCookie = new Cookie("rememberUsername", username);
		response.addCookie(usernameCookie);
	}
}