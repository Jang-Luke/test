package kh.spring.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import kh.spring.dto.MovieDto;

@Repository
public interface MovieRepository {
	public void save(MovieDto Movie) throws SQLException;
	public List<MovieDto> findAll() throws SQLException;
}
