package com.amanda.readlog.controller;

import com.amanda.readlog.model.User;
import com.amanda.readlog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // TODO: implementar autenticação
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
