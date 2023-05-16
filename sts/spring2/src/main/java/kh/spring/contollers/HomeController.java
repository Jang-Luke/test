package kh.spring.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String test(@RequestParam String param, Model model) {
		model.addAttribute("param", param);
		return "test";
	}
}
