package kh.study.khspring.service;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {
    List<Board> findAll() throws SQLException;

    void save(BoardDto boardDto) throws SQLException;

    Board findById(Long boardId) throws SQLException;

    void delete(Long boardId) throws SQLException;

    void modify(Long boardId, Board board) throws SQLException;
}
