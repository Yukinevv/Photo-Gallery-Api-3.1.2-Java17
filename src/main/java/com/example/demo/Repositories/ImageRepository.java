package com.example.demo.Repositories;

import com.example.demo.Models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}

