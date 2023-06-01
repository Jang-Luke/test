package kh.study.khspring.controller;

import kh.study.khspring.dto.Chat;
import kh.study.khspring.dto.ChatDto;
import kh.study.khspring.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatService chatService;
    private final HttpSession session;
    private final SimpMessagingTemplate smt;

    @MessageMapping("/message")
    public void message(ChatDto chatDto) {
        System.out.println("chatDto = " + chatDto);
        System.out.println("chatDto.Sender = " + chatDto.getSender());
        System.out.println("chatDto.Message = " + chatDto.getMessage());
        Chat chat = new Chat(0L, chatDto.getSender(), chatDto.getMessage(), LocalDateTime.now());
        chatService.save(chat);
        if (chatDto.getSender().equals(session.getAttribute("loginId"))){
            return;
        };
        smt.convertAndSend("/topic/chat", chatDto);
    }
    // @SendTo 는 전송하고자 하는 구독 채널명이 고정되어 있을 때 편리하게 사용 가능
    // SimpleMessagingTemplate 은 전송하고자 하는 구독 채널명이 동적으로 변경될 때 사용 가능

    @SubscribeMapping("/topic/chat")
    public void chatSubscription() {
        List<Chat> list = chatService.findAll();
        smt.convertAndSend("/topic/chat", list);
    }

}
