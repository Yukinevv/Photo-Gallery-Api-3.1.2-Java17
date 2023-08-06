package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;
    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
