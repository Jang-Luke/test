package kh.spring.endpoint;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {
	
	private Session session;

	@OnOpen
	public void onConnect(Session session) {
		System.out.println("웹소켓 연결 확인");
		this.session = session;
	}
	
	@OnMessage
	public void onMessage(String message) {
		System.out.println(message);
		try {
			session.getBasicRemote().sendText(message);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@OnClose
	public void onClose() {
		System.out.println("웹 소켓 연결 해제");
	}
	
	@OnError
	public void onError(Throwable T) {
		System.out.println("웹 소켓 통신 오류");
	}
}
