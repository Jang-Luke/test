package kh.study.khspring.service;

import kh.study.khspring.dto.Chat;

import java.util.List;

public interface ChatService {
    void save(Chat chat);
    List<Chat> findAll();
}
