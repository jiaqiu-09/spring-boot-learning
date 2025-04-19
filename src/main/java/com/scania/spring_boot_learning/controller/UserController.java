package com.scania.spring_boot_learning.controller;

import com.scania.spring_boot_learning.pojo.ResponseMessage;
import com.scania.spring_boot_learning.pojo.User;
import com.scania.spring_boot_learning.pojo.dto.UserDto;
import com.scania.spring_boot_learning.service.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserInterface userInterface;

    @PostMapping
    public ResponseMessage<User> add(@RequestBody UserDto user) {
        try {
            return ResponseMessage.success(userInterface.add(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMessage.error("Error adding user: " + e.getMessage(), null);
        }
    }
}
