package kh.study.khspring.endpoint;

import com.google.common.collect.EvictingQueue;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kh.study.khspring.configurator.ServerEndpointConfigurator;
import kh.study.khspring.dto.ChatDto;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@ServerEndpoint(value = "/chat", configurator= ServerEndpointConfigurator.class)
public class ChatEndpoint {

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
    private static EvictingQueue<ChatDto> messageHistory = EvictingQueue.create(100);
    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        clients.add(session);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(messageHistory));
        } catch (IOException e) {
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        String id = (String)httpSession.getAttribute("loginId");
        ChatDto chatDto = new ChatDto(id, message, LocalDateTime.now());
        messageHistory.add(chatDto);
        synchronized (clients) {
            for (Session client : clients) {
                if (client == session) {continue;}
                try {
                    client.getBasicRemote().sendText(new Gson().toJson(chatDto));
                } catch (Exception e) {
                }
            }
        }
    }

    @OnClose
    public void onClose() {
        System.out.println("웹 소켓 연결 종료");
    }

    @OnError
    public void onError(Throwable T) {
        System.out.println(T.getClass());
    }
}
