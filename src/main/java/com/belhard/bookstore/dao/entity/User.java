package com.belhard.bookstore.dao.entity;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private Role role;

    public enum Role {
        ADMIN,
        MANAGER,
        CUSTOMER
    }
}
