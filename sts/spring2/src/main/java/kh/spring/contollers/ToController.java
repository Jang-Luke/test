package kh.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.spring.dto.MovieDto;

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
	
	@PostMapping("/inputProc")
	public String inputProc(MovieDto movie) {
		return "redirect:/";
	}
}
