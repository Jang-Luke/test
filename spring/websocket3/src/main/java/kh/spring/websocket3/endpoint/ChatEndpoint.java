package kh.spring.websocket3.endpoint;

import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    @OnOpen
    public void onConnect() {
        System.out.println("웹소켓 연결 확인");
    }
}
