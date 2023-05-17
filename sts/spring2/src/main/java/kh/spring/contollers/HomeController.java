package kh.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@PostMapping("/")
	public String test(@RequestParam String param, Model model) {
		model.addAttribute("param", param);
		return "test";
	}
	@GetMapping("/toInput")
	public String toInput() {
		return "input";
	}
	@GetMapping("/toOutput")
	public String toOutput() {
		return "output";
	}
}
