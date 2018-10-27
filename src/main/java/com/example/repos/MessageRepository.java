package com.example.repos;

import com.example.domain.Message;
import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByAuthor(User user);
}
