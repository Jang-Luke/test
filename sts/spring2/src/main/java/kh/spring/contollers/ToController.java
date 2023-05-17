package kh.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@PostMapping("inputProc")
	public String inputProc(@RequestParam String title, @RequestParam String genre) {
//		String title = request.getParameter("title");
//		String genre = request.getParameter("genre");
		
		System.out.println(title);
		System.out.println(genre);
		return "redirect:/";
	}
}
