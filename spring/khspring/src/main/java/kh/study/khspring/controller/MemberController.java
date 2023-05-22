package kh.study.khspring.controller;

import kh.study.khspring.dto.Encryptable;
import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.dto.LoginResponse;
import kh.study.khspring.dto.Member;
import kh.study.khspring.service.MemberService;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;

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
        return "members/signup";
    }

    @PostMapping("/signup")
    public String signup(Member member) {
        encryptPassword(member);
        memberService.save(member);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        Optional.ofNullable(loginDto.getRememberUsername())
            .ifPresentOrElse(e -> addUsernameCookie(loginDto.getUsername(), response),
                () -> Optional.ofNullable(request.getCookies())
                .ifPresent(
                    (e) -> Arrays.stream(e)
                    .filter(c -> c.getName().equals("rememberUsername"))
                    .findFirst()
                    .ifPresent(c -> removeUsernameCookie(c, response))
                )
            );


//        Arrays.stream(request.getCookies())
//                .filter(e -> e.getName().equals("rememberUsername"))
//                .findAny()
//                .ifPresent(c -> removeUsernameCookie(c, response));
//
//        if (loginDto.getRememberUsername()) {
//            addUsernameCookie(loginDto.getUsername(), response);
//        } else {
//        }
        LoginResponse loginResponse = memberService.login(loginDto);
        if (passwordEncryptor.checkPassword(loginDto.getPassword(), loginResponse.getPassword())) {
            session.setAttribute("loginId", loginDto.getUsername());
        } else {
            throw new RuntimeException();
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        String loginId = String.valueOf(session.getAttribute("loginId"));
        if (loginId != null) {
            session.removeAttribute("loginId");
        }
        return "redirect:/";
    }

    @PostMapping(
            value = "/idCheck",
            produces = "text/html;charset=utf8"
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

    private void addUsernameCookie(String username, HttpServletResponse response) {
        Cookie usernameCookie = new Cookie("rememberUsername", username);
        usernameCookie.setMaxAge(7);
        usernameCookie.setSecure(false);
        response.addCookie(usernameCookie);
    }

    private void removeUsernameCookie(Cookie cookie, HttpServletResponse response) {
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
