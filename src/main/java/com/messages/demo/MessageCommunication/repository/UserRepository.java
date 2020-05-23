package com.messages.demo.MessageCommunication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.messages.demo.MessageCommunication.model.User;


@Repository()
public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findById(Long id);
    
    @Query("select u from User u where u.username = :username")
    User findByname(String username);
   
}
