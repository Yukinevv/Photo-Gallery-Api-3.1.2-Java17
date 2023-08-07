package com.example.demo.Services;

import com.example.demo.Models.Image;
import com.example.demo.Repositories.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public ResponseEntity<Map<String, String>> saveImage(String filename, byte[] data) {
        try {
            Image image = new Image(filename, data);
            imageRepository.save(image);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Image uploaded successfully");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Blad podczas zapisu obrazu do bazy: " + e.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
