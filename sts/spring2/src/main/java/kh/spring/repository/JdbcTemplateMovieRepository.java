package kh.spring.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MovieDto;

@Repository
public class JdbcTemplateMovieRepository implements MovieRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplateMovieRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void save(MovieDto movie) throws SQLException {
		String sql = "insert into movies values(movie_seq.nextval, ?, ?)";
		jdbcTemplate.update(sql, movie.getTitle(), movie.getGenre());
	}

	@Override
	public List<MovieDto> findAll() throws SQLException {
		String sql = "select * from movies";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MovieDto>(MovieDto.class));
	}

	@Override
	public void delete(Long id) throws SQLException {
		String sql = "delete from movies where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void modify(MovieDto movie) throws SQLException {
		String sql = "update movies set title = ?, genre = ? where id = ?";
		jdbcTemplate.update(sql, movie.getTitle(), movie.getGenre(), movie.getId());
	}
	
}
