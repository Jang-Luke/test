package kh.spring.contollers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MovieDto;
import kh.spring.repository.MovieRepository;

@Controller
@RequestMapping("/movie")
public class MovieController {

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/list")
	public String movieList(Model model) {
		try {
			List<MovieDto> movies = movieRepository.findAll();
			model.addAttribute("movies", movies);
			return "/movie/list";
		} catch (SQLException e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}
	
	@PostMapping("/register")
	public String movieRegister(MovieDto movie) {
		try {
			movieRepository.save(movie);
			return "home";
		} catch (SQLException e) {
			e.printStackTrace();
			return "rediect:/error";
		}
	}
}
