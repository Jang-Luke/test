package kh.study.khspring.service;

import kh.study.khspring.dto.Chat;
import kh.study.khspring.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public void save(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }
}
