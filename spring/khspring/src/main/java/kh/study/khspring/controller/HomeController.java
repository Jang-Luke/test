package kh.study.khspring.controller;

import kh.study.khspring.dto.Movie;
import kh.study.khspring.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MyBatisRepository myBatisRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/mybatis")
    public String toMybatis() {
        return "/mybatis/mybatis";
    }

    @GetMapping("/serchByCondition")
    public String searchByCondition(SearchDto searchDto, Model model) throws Exception {
        List<Movie> movies = myBatisRepository.selectByCondition(searchDto);
        model.addAttribute("movies", movies);
        return "/mybatis/mybatis";
    }

    @GetMapping("/serchByMultiCondition")
    public String searchByMultiCondition(@ModelAttribute Movie movie, Model model) throws Exception {
        List<Movie> movies = myBatisRepository.selectByMultiCondition(movie);
        model.addAttribute("movies", movies);
        return "/mybatis/mybatis";
    }
}
