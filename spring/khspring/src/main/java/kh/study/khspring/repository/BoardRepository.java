package kh.study.khspring.repository;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;

import java.sql.SQLException;
import java.util.List;

public interface BoardRepository {
    List<Board> findAll() throws SQLException;

    void save(BoardDto boardDto) throws SQLException;

    Board findById(Long boardId)throws SQLException;
}
