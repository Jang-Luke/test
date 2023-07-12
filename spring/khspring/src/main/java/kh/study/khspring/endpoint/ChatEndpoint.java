//package kh.study.khspring.endpoint;
//
//import com.google.common.collect.EvictingQueue;
//import com.google.gson.Gson;
//import kh.study.khspring.config.HttpSessionConfigurator;
//import kh.study.khspring.dto.ChatDto;
//import kh.study.khspring.config.SpringProvider;
//import kh.study.khspring.service.ChatService;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.*;
//
//@ServerEndpoint(value = "/chat", configurator= HttpSessionConfigurator.class)
//public class ChatEndpoint {
//
//    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
//    private static EvictingQueue<ChatDto> messageHistory = EvictingQueue.create(100);
//    private static ChatService chatService;
//    private HttpSession httpSession;
//
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config) {
//        clients.add(session);
//        chatService = SpringProvider.getApplicationContext().getBean(ChatService.class);
//        this.httpSession = (HttpSession) config.getUserProperties().get("httpSession");
//        List<ChatDto> chatHistory = chatService.findAll();
//        try {
//            session.getBasicRemote().sendText(new Gson().toJson(chatHistory));
//        } catch (IOException e) {
//        }
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        String sender = (String)httpSession.getAttribute("loginId");
//        ChatDto chatDto = new ChatDto(0L, sender, message, LocalDateTime.now());
//        chatService.save(chatDto);
////        messageHistory.add(chatDto);
//        synchronized (clients) {
//            for (Session client : clients) {
//                if (client == session) {continue;}
//                try {
//                    client.getBasicRemote().sendText(new Gson().toJson(chatDto));
//                } catch (Exception e) {
//                }
//            }
//        }
//    }
//
//    @OnClose
//    public void onClose() {
//        System.out.println("웹 소켓 연결 종료");
//    }
//
//    @OnError
//    public void onError(Throwable T) {
//        T.printStackTrace();
//        System.out.println(T.getClass());
//    }
//}
