package kh.study.khspring.repository;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//@Repository
//@RequiredArgsConstructor
public class MysqlBoardRepository implements BoardRepository {

//    private final JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Board> findAll() throws SQLException {
        String sql = "select * from boards";
        List<Board> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
        return boards;
    }

    @Override
    public void save(BoardDto boardDto) throws SQLException {
        String sql = "insert into boards values(0, ?, ?, ?, default, default, default)";
        jdbcTemplate.update(sql, boardDto.getWriter(), boardDto.getTitle(), boardDto.getContent());
    }

    @Override
    public Board findById(Long boardId) throws SQLException {
        String sql = "select * from boards where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class), boardId);
    }

    @Override
    public BoardRepository increaseViewCount(Long boardId) throws SQLException {
        String sql = "update boards set view_count = +1 where id = ?";
        jdbcTemplate.update(sql, boardId);
        return this;
    }

    @Override
    public void delete(Long boardId) throws SQLException {

    }

    @Override
    public void modify(Long boardId, Board board) throws SQLException {

    }
}
