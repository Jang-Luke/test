package kh.spring.dto;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MovieDto {
	private AtomicInteger idSupplier;
	@Nullable
	private int id;
	private String title;
	private String genre;
	
	
	public MovieDto() {
	}
	
	@Autowired
	public MovieDto(AtomicInteger atomicInteger) {
		this.idSupplier = atomicInteger;
	}
	
	public MovieDto(int id, String title, String genre) {
		this.id = id;
		this.title = title;
		this.genre = genre;
	}
	
	AtomicInteger getIdSupplier() {
		return idSupplier;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
