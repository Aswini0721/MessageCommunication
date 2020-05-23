package com.messages.demo.MessageCommunication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "userdetails")
@EntityScan(basePackages = "com.example.websocketdemo.model")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(name = "userName", nullable = false)
    private String username;
    
   /* @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private List<User_Messages> messageInfo;*/

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

/*	public List<User_Messages> getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(List<User_Messages> messageInfo) {
		this.messageInfo = messageInfo;
	}*/

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}








   
}
