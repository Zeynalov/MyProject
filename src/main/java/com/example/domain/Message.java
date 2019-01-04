package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Getter @Setter
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String application;
    private String applicationStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private User author;

    @ElementCollection(targetClass = OrderStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "message_id"))
    @Enumerated(EnumType.STRING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderStatus> orderStatus;

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Message() {
    }

    public Message(String application, String applicationStatus, User user) {
        this.author = user;
        this.application = application;
        this.applicationStatus = applicationStatus;
    }
}
