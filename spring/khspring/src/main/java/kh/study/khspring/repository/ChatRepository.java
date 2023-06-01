package kh.study.khspring.repository;

import kh.study.khspring.dto.Chat;

import java.util.List;

public interface ChatRepository {

    void save(Chat chat);

    List<Chat> findAll();
}
