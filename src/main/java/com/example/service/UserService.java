package com.example.service;

import com.example.domain.Message;
import com.example.domain.Role;
import com.example.domain.User;
import com.example.repos.MessageRepository;
import com.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<Message> getMessages(Principal principal) {
        User username = userRepository.findByUsername(principal.getName());
        Set<Role> roles = username.getRoles();
        List<Message> byAuthor;
        if (roles.contains(Role.ADMIN)) {
            byAuthor = messageRepository.findAll();
        } else {
            byAuthor = messageRepository.findByAuthor(username);
        }
        return byAuthor;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return true;
    }
}
