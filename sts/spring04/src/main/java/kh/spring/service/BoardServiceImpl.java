package kh.spring.service;

import org.springframework.stereotype.Service;

import kh.spring.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
}
