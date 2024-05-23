package com.test.websocket.domain;

import javax.websocket.server.ServerEndpoint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
	
	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
	
}
