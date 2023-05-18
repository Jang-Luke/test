package kh.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MovieDto;

@Repository
public class OracleMovieRepository implements MovieRepository {
	
	private DataSource dataSource;
	
	@Autowired
	public OracleMovieRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(MovieDto movie) throws SQLException {
		String sql = "insert into movies values(movie_seq.nextval, ?, ?)";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//			preparedStatement.setInt(1, movie.getId());
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getGenre());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException();
			}
		}
	}

	@Override
	public List<MovieDto> findAll() throws SQLException {
		String sql = "select * from movies";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery()){
			List<MovieDto> movies = new ArrayList<>();
			while (resultSet.next()) {
				movies.add(mapRow(resultSet));
			}
			return movies;
		}
	}
	
	@Override
	public void delete(Long id) throws SQLException {
		String sql = "delete from movies where id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setLong(1, id);
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException();
			}
		}
	}
	
	@Override
	public void modify(MovieDto movie) throws SQLException {
		String sql = "update movies set title = ?, genre = ? where id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getGenre());
			preparedStatement.setLong(3, movie.getId());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException();
			}
		}
	}

	private MovieDto mapRow(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong(1);
		String title = resultSet.getString(2);
		String genre = resultSet.getString(3);
		return new MovieDto(id, title, genre);
	}
}
