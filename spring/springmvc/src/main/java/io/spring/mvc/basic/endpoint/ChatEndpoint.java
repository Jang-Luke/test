package io.spring.mvc.basic.endpoint;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static List<Session> clients = new ArrayList<>();

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("웹소켓 연결 확인");
        ChatEndpoint.clients.add(session);
    }


    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
        try {
            for (Session session : clients) {
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session s) {
        System.out.println("웹 소켓 연결 해제");
        clients.remove(s);
    }

    @OnError
    public void onError(Session s) {
        System.out.println("웹 소켓 통신 오류");
        clients.remove(s);
    }
}
