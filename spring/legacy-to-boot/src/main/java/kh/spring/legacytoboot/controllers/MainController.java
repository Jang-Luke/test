package kh.spring.legacytoboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String test(@RequestParam(name = "myMessage", defaultValue = "") String myMessage, Model model) {
        model.addAttribute("myMessage", myMessage);
        return "test";
    }
}
