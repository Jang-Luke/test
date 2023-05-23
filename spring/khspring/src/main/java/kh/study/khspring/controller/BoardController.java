package kh.study.khspring.controller;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
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
        return "redirect:/boards";
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

    @GetMapping("/{boardId}/delete")
    public String delete(@PathVariable Long boardId) throws SQLException {
        boardService.delete(boardId);
        return "/boards/list";
    }

    @GetMapping("/{boardId}/modify")
    public String toModifyForm(@PathVariable Long boardId, Model model) throws SQLException {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "/boards/modify";
    }

    @PostMapping("/{boardId}/modify")
    public String modify(@PathVariable Long boardId, @ModelAttribute Board board) throws SQLException {
        boardService.modify(boardId, board);
        return "redirect:/boards/{boardId}";
    }

    @ExceptionHandler(SQLException.class)
    public String sqlExceptionHandler(SQLException e, Model model) {
        e.printStackTrace();
        model.addAttribute("exceptionType", e.getClass());
        model.addAttribute("exceptionCause", e.getCause());
        return "/error";
    }
}
