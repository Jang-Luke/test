package kh.study.khspring.controller;

import kh.study.khspring.entity.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.entity.Files;
import kh.study.khspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final HttpSession session;

    @GetMapping
    public String findAll(Model model) throws SQLException {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "/boards/datatablelist";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "/boards/register";
    }

    @PostMapping
    public String register(BoardDto boardDto, MultipartFile[] files) throws Exception {
        String realPath = session.getServletContext().getRealPath("upload");
        boardService.save(boardDto, files, realPath);
        return "redirect:/boards";
    }

    @GetMapping("/{boardId}")
    public String viewTarget(@PathVariable(name = "boardId") Long boardId, Model model) throws SQLException {
        Board board = boardService.findBoardById(boardId);
        List<Files> files = boardService.findFilesByBoardId(boardId);
        model.addAttribute("board", board);
        model.addAttribute("files", files);
        return "/boards/item";
    }

    @GetMapping("/{boardId}/delete")
    public String delete(@PathVariable Long boardId) throws SQLException {
        boardService.delete(boardId);
        return "/boards/list";
    }

    @GetMapping("/{boardId}/modify")
    public String toModifyForm(@PathVariable Long boardId, Model model) throws SQLException {
        Board board = boardService.findBoardById(boardId);
        model.addAttribute("board", board);
        return "/boards/modify";
    }

    @PostMapping("/{boardId}/modify")
    public String modify(@PathVariable Long boardId, @ModelAttribute Board board) throws SQLException {
        boardService.modify(boardId, board);
        return "redirect:/boards/{boardId}";
    }

    @ExceptionHandler(Exception.class)
    public String sqlExceptionHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("exceptionType", e.getClass());
        model.addAttribute("exceptionCause", e.getCause());
        return "/error";
    }
}
