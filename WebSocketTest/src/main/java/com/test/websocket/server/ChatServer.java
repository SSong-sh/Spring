package com.test.websocket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.websocket.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	//현재 채팅 서버에 접속한 클라이언트 세션
	private static List<Session> sessionList = new ArrayList<Session>();
	
	
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트가 접속했습니다.");
		
		sessionList.add(session);
	}
	
	
	//여기서 session은 내꺼
	@OnMessage
	public void handleMessage(String msg, Session session) {
		
		//System.out.println(msg);
		
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		System.out.println(message);
		
		if(message.getCode().equals("1")) {
			
			//새로운 유저가 접속했습니다.
		for (Session s : sessionList) {
			if( s != session) {
					try {
						
						s.getBasicRemote().sendText(msg);
						
					} catch (IOException e) {
		
						e.printStackTrace();
					}
				}
			}
			
		} else if (message.getCode().equals("2")) {
			
			//기존 유저가 나갔습니다
			sessionList.remove(session);
			
			for (Session s : sessionList) {
					try {
						
						s.getBasicRemote().sendText(msg);
						
					} catch (IOException e) {
		
						e.printStackTrace();
					}
			}
			
		} else if (message.getCode().equals("3")) {
			
			//대화 내용을 전달
			for (Session s : sessionList) {
				if( s != session) {
						try {
							
							s.getBasicRemote().sendText(msg);
							
						} catch (IOException e) {
			
							e.printStackTrace();
						}
					}
				}
		} else if (message.getCode().equals("4")) {
			
			//대화 내용을 전달
			for (Session s : sessionList) {
				if( s != session) {
						try {
							
							s.getBasicRemote().sendText(msg);
							
						} catch (IOException e) {
			
							e.printStackTrace();
						}
					}
				}
		}
		
	}
	
	
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 연결이 종료되었습니다.");
	}
	
	
	@OnError
	public void handleError(Throwable e) {
		
	}
}
