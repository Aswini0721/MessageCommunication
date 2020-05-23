package com.messages.demo.MessageCommunication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.messages.demo.MessageCommunication.model.User;
import com.messages.demo.MessageCommunication.model.User_Messages;
import com.messages.demo.MessageCommunication.repository.MessageRepository;
import com.messages.demo.MessageCommunication.repository.UserRepository;
import com.messages.demo.MessageCommunication.model.ChatMessage;
 
@Controller
public class WebSocketController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private MessageRepository messageRepository; 
 
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage saveMessage(@Payload ChatMessage chatMessage) {
    	String username = chatMessage.getSender();
        User user = userRepository.findByname(username);
        if(null != user) {
	        System.out.println("user Name saved in DB" + user.toString());
	        User_Messages messages = new User_Messages();
	        messages.setMessageInfo(chatMessage.getContent());
	        messages.setUser(user);
	        messages.setDate(new Date());
	        messageRepository.save(messages);           
	        System.out.println("user Details saved in DB" + user.toString());
	        System.out.println("Messages saved in DB" + messages.toString());
        }
        return chatMessage;
    }
 
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    	 // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        User user = new User();
        User exitUser = userRepository.findByname(chatMessage.getSender());
        if(null == exitUser) {
        	user.setUsername(chatMessage.getSender());
        	 userRepository.save(user);  
             System.out.println("user Id saved in DB" + user.getUserId());           
        } 
        return chatMessage;
    }
 
}
