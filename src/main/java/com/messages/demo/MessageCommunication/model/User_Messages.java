package com.messages.demo.MessageCommunication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_messages")
public class User_Messages {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    
    @Column(name = "messages", nullable = false)
    private String messageInfo;
    
    @Column(name = "modified_date", nullable = false)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User_Messages [messageId=" + messageId + ", messageInfo=" + messageInfo + ", date=" + date + ", user="
				+ user + "]";
	} 
}
