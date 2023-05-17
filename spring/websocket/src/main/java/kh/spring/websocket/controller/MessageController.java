package kh.spring.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
public class MessageController extends Socket {

    private static final List<Session> session = new ArrayList<>();

    @GetMapping("/")
    public String intex() {
        return "index";
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println("현재 접속중인 유저 수 : " + session.size());
    }

    @OnMessage
    public void getMessage(Session recieveSession, String message) {
        try {
            for (int i = 0; i < session.size(); i++) {
                if (!recieveSession.getId().equals(session.get(i).getId())) {
                    session.get(i).getBasicRemote().sendText("상대 : " + message);
                } else {
                    session.get(i).getBasicRemote().sendText("나 : " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
