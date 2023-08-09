package com.example.demo.Controllers;

import com.example.demo.Models.Image;
import com.example.demo.Services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/images")
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping
    public List<Image> fetchAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{login}")
    public List<Image> fetchAllUserImages(@PathVariable("login") String login) {
        return imageService.getAllUserImages(login);
    }

    @PostMapping("/upload/{login}")
    public ResponseEntity<Map<String, String>> saveImage(@PathVariable("login") String login, @RequestBody MultipartFile image) {
        try {
            return imageService.saveImage(image.getOriginalFilename(), image.getBytes(), login);
        } catch (Exception e) {
            System.out.println("Blad: " + e.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteImage(@PathVariable("id") String id) {
        return imageService.deleteImage(id);
    }

    @PutMapping("/editFilename/{id}/{newFilename}")
    public ResponseEntity<Map<String, String>> editFilename(@PathVariable("id") String id, @PathVariable("newFilename") String newFilename) {
        return imageService.editFilename(id, newFilename);
    }
}
