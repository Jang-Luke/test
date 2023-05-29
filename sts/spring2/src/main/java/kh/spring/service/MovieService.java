package kh.spring.service;

import java.sql.SQLException;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dto.MovieDto;
import kh.spring.repository.MovieRepository;

@Service
@Transactional
public class MovieService {

	MovieRepository movieRepository;
	DataSourceTransactionManager transactionManager;
	
	public void transactionTest(MovieDto movie) {
		try {
			movieRepository.save(movie);
			movieRepository.insertHistory(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
