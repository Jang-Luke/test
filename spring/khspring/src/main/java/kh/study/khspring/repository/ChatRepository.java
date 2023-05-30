package kh.study.khspring.repository;

import kh.study.khspring.dto.ChatDto;

import java.util.List;

public interface ChatRepository {

    void save(ChatDto chatDto);

    List<ChatDto> findAll();
}
