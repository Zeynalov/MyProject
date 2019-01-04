package com.example.controller;

import com.example.domain.Message;
import com.example.domain.OrderStatus;
import com.example.domain.Role;
import com.example.domain.User;
import com.example.repos.MessageRepository;
import com.example.repos.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model, Principal principal) {
        List<Message> byAuthor = userService.getMessages(principal);
        model.put("messages", byAuthor);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String application,
            @RequestParam String applicationStatus, Map<String, Object> model) {
        Message message = new Message(application, applicationStatus, user);
        message.setOrderStatus(Collections.singleton(OrderStatus.BEING_PROCESSED));
        messageRepository.save(message);
        return "main";
    }

    @GetMapping("/order")
    public String order(Map<String, Object> model, Principal principal) {
        List<Message> byAuthor = userService.getMessages(principal);
        model.put("messages", byAuthor);
        return "order";
    }

}
