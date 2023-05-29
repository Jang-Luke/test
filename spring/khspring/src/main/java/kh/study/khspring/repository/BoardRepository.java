package kh.study.khspring.repository;

import kh.study.khspring.entity.Board;
import kh.study.khspring.dto.BoardDto;

import java.sql.SQLException;
import java.util.List;

public interface BoardRepository {
    List<Board> findAll() throws SQLException;

    Long save(Board board) throws SQLException;

    Board findById(Long boardId) throws SQLException;

    BoardRepository increaseViewCount(Long boardId) throws SQLException;

    void delete(Long boardId) throws SQLException;

    void modify(Long boardId, Board board) throws SQLException;
}
