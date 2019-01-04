package com.example.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {
    BEING_PROCESSED ("Being processed"),
    AWAITING ("Awaiting"),
    ACCEPTED ("Accepted"),
    REJECTED ("Rejected");

    private String name;

    OrderStatus (String name) {
        this.name = name;
    }
}
