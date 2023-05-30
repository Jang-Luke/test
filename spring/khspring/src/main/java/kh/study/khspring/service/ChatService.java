package kh.study.khspring.service;

import kh.study.khspring.dto.ChatDto;

import java.util.List;

public interface ChatService {
    void save(ChatDto chatDto);
    List<ChatDto> findAll();
}
