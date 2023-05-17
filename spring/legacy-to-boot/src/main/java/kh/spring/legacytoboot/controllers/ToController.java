package kh.spring.legacytoboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/to")
public class ToController {

    @GetMapping("/input")
    public String toInput() {
        return "inputForm";
    }

    @GetMapping("/output")
    public String toOutput() {
        return "outputForm";
    }
}
