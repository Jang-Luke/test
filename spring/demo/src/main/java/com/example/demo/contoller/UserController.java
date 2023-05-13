package com.example.demo.contoller;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("method", "GET");
        return "hello";
    }

    @PostMapping(value = "/hello")
    public String hello(@RequestParam(name = "message", defaultValue = "") String message, Model model) {
        model.addAttribute("message", message);
        model.addAttribute("method", "POST");
        return "hello";
    }
}
