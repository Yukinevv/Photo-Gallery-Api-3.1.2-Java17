package com.example.demo.Services;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.Models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> fetchUser(User user) {
        User _user = userRepository.findByLogin(user.getLogin());

        if (_user != null && _user.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(_user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> addUser(User user) {
        try {
            User _user = userRepository.save(new User(user.getLogin(), user.getPassword(), user.getEmail()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
