package kh.study.khspring.service;

import kh.study.khspring.entity.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.entity.Files;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public interface BoardService {
    List<Board> findAll() throws SQLException;

    void save(BoardDto boardDto, MultipartFile[] files, String filePath) throws Exception;

    Board findBoardById(Long boardId) throws SQLException;

    void delete(Long boardId) throws SQLException;

    void modify(Long boardId, Board board) throws SQLException;

    List<Files> findFilesByBoardId(Long boardId) throws SQLException;
}
