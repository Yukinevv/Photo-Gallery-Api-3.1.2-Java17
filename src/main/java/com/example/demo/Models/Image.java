package com.example.demo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "images")
public class Image {

    @Id
    private String id;
    private String filename;
    private byte[] data;

    private String login;
    private String category;

    public Image(String filename, byte[] data, String login, String category) {
        this.filename = filename;
        this.data = data;
        this.login = login;
        this.category = category;
    }
}

