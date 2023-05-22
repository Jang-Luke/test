package kh.study.khspring.repository;

import kh.study.khspring.dto.Board;
import kh.study.khspring.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class MysqlBoardRepository implements BoardRepository {
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
}
