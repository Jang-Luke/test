package kh.spring.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import kh.spring.dto.MovieDto;

@Repository
public interface MovieRepository {
	public void save(MovieDto movie) throws SQLException;
	public List<MovieDto> findAll() throws SQLException;
	public void delete(Long id) throws SQLException;
	public void modify(MovieDto movie) throws SQLException;
	public void insertHistory(MovieDto movie) throws SQLException;
}