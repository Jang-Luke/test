package kh.study.khspring.service;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

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
        return boardRepository.increaseViewCount(boardId)
                                .findById(boardId);
    }

    @Override
    public void delete(Long boardId) throws SQLException {
        boardRepository.delete(boardId);
    }

    @Override
    public void modify(Long boardId, Board board) throws SQLException {
        boardRepository.modify(boardId, board);
    }
}
