package com.messages.demo.MessageCommunication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.messages.demo.MessageCommunication.model.User_Messages;

@Repository()
public interface MessageRepository extends JpaRepository<User_Messages, Long> {
	
    Optional<User_Messages> findById(Long id);
    
    @Query("SELECT m FROM User_Messages m LEFT JOIN m.user as u ORDER BY m.date DESC")
    List<User_Messages> findAllByUserId();
    
   
    
}
