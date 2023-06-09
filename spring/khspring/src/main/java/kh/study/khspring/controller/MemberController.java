package kh.study.khspring.controller;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import kh.study.khspring.dto.LoginDto;
import kh.study.khspring.entity.Member;
import kh.study.khspring.service.MemberService;
import lombok.RequiredArgsConstructor;
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
import java.util.Properties;
import java.util.UUID;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/signup")
    public String toSignup() {
        return "members/signup";
    }

    @PostMapping("/signup")
    public String signup(Member member) {
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
        String loginId = memberService.login(loginDto);
        session.setAttribute("loginId", loginId);
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

    @PostMapping(value = "/email", produces = "text/html;charset=utf8")
    @ResponseBody
    public String email(String email) {
        System.out.println(email);
        String code = UUID.randomUUID() + "_custom_CODE";
        final String senderEmail = "syhrje10@gmail.com";
        final String senderPassword = "nzbsqswqgylbzwjo";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("prop = " + prop);
        Session session = Session.getDefaultInstance(prop, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        System.out.println("session = " + session);
        MimeMessage message = new MimeMessage(session);
        System.out.println("message = " + message);
        try {
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("자바 메일 전송 테스트");
            message.setText("This is the TEST to send e-main with java !");
            message.setText(code);
            Transport.send(message);
            System.out.println("message = " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success!";
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
