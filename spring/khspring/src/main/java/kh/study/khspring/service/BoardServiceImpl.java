package kh.study.khspring.service;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;

    @Override
    public List<Board> findAll() throws SQLException {
        return boardRepository.findAll();
    }

    @Override
    public void save(BoardDto boardDto) throws SQLException {
        boardRepository.save(boardDto);
    }

    @Override
    public Board findById(Long boardId) throws SQLException {
        return boardRepository.findById(boardId);
    }
}
