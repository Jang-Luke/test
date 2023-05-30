package kh.study.khspring.service;

import kh.study.khspring.dto.ChatDto;
import kh.study.khspring.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public void save(ChatDto chatDto) {
        chatRepository.save(chatDto);
    }

    @Override
    public List<ChatDto> findAll() {
        return chatRepository.findAll();
    }
}
