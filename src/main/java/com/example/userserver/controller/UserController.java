package com.example.userserver.controller;

import com.example.userserver.dto.UserDto;
import com.example.userserver.dto.UserSaveRequest;
import com.example.userserver.entity.ColorArticle;
import com.example.userserver.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserByAge")
    public List<UserDto> getUserByAge(Integer age) {
        return userService.getUserByAge(age);
    }

    @PostMapping("/getUserByColorArticle")
    public List<UserDto> getUserByColorArticle(@RequestParam ColorArticle color) {
        return userService.getUserByColorArticle(color);
    }

    @GetMapping("/getUserByCount")
    public List<String> getUserByCount(int count) {
        return userService.getUserByCount(count);
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        userService.saveUser(userSaveRequest);
    }
}