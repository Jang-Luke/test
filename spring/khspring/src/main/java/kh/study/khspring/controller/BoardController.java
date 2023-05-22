package kh.study.khspring.controller;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/boards")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public String findAll(Model model) throws SQLException {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "/boards/list";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "/boards/register";
    }

    @PostMapping
    public String register(BoardDto boardDto) throws SQLException {
        boardService.save(boardDto);
        return "redirect:/boards/list";
    }

    @GetMapping("/{boardId}")
    public String viewTarget(@PathVariable(name = "boardId") Long boardId, Model model) throws SQLException {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "/boards/item";
    }

    @GetMapping("/datatablelist")
    public String toDataTable(Model model) throws SQLException {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "/boards/datatablelist";
    }

    @ExceptionHandler(SQLException.class)
    public String sqlExceptionHandler(SQLException e, Model model) {
        e.printStackTrace();
        model.addAttribute("exceptionType", e.getClass());
        model.addAttribute("exceptionCause", e.getCause());
        return "/error";
    }
}
