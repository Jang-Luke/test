package kh.spring.contollers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public String movieList(Model model) throws Exception {
		List<MovieDto> movies = movieRepository.findAll();
		model.addAttribute("movies", movies);
		return "/movie/list";
	}

	@PostMapping("/register")
	public String movieRegister(MovieDto movie) throws Exception {
		movieRepository.save(movie);
		return "home";
	}

	@GetMapping("/delete")
	public String toDeleteForm() {
		return "/movie/deleteForm";
	}
	
	@PostMapping("/delete")
	public String movieDelete(Long deleteId) throws Exception {
		movieRepository.delete(deleteId);
		return "redirect:/movie/list";
	}
	
	@GetMapping("/modify")
	public String toModifyForm() {
		return "/movie/modifyForm";
	}
	
	@PostMapping("/modify")
	public String movieModify(MovieDto movie) throws Exception {
		movieRepository.modify(movie);
		return "redirect:/movie/list";
	}
	
	@ExceptionHandler(SQLException.class)
	public String sqlExceptionHandler(SQLException e, Model model) {
		e.printStackTrace();
		model.addAttribute("exceptionType", e.getClass().toString());
		model.addAttribute("exceptionMessage", e.getMessage());
		return "error";
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointExceptionHandler(NullPointerException e, Model model) {
		e.printStackTrace();
		model.addAttribute("exceptionType", e.getClass().toString());
		model.addAttribute("exceptionMessage", e.getMessage());
		return "error";
	}

}
