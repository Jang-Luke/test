package kh.study.khspring.repository;

import kh.study.khspring.entity.Board;
import kh.study.khspring.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisBoardRepository implements BoardRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Board> findAll() throws SQLException {
        return sqlSessionTemplate.selectList("Boards.selectAll");
    }

    @Override
    public Long save(Board board) {
        sqlSessionTemplate.insert("Boards.insert", board);
        return board.getId();
    }

    @Override
    public Board findById(Long boardId) throws SQLException {
        return sqlSessionTemplate.selectOne("Boards.select", boardId);
    }

    @Override
    public BoardRepository increaseViewCount(Long boardId) throws SQLException {
        sqlSessionTemplate.update("Boards.increaseViewCount", boardId);
        return this;
    }

    @Override
    public void delete(Long boardId) throws SQLException {
        sqlSessionTemplate.delete("Boards.delete", boardId);
    }

    @Override
    public void modify(Long boardId, Board board) throws SQLException {
        sqlSessionTemplate.update("Boards.update", board);
    }
}
