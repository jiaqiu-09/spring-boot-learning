package com.scania.spring_boot_learning.controller;

import com.scania.spring_boot_learning.pojo.ResponseMessage;
import com.scania.spring_boot_learning.pojo.User;
import com.scania.spring_boot_learning.pojo.dto.UserDto;
import com.scania.spring_boot_learning.service.IUserInterface;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserInterface userInterface;

    @PostMapping
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user) {
        return ResponseMessage.success(userInterface.add(user));
    }

    @PutMapping
    public ResponseMessage<User> edit(@Validated @RequestBody UserDto user) {
        User userPojo = userInterface.get(user.getUserId());
        if (userPojo == null) {
            return ResponseMessage.error("User with ID " + user.getUserId() + " not found", "User not found");
        }
        return ResponseMessage.success(userInterface.edit(user));
    }

    @GetMapping()
    public ResponseMessage<User> get(@RequestParam @NotNull(message = "User ID cannot be null") Integer id) {
        User user = userInterface.get(id);
        if (user == null) {
            return ResponseMessage.error("User with ID " + id + " not found", "User not found");
        }
        return ResponseMessage.success(user);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<User> delete(@PathVariable @NotNull(message = "User ID cannot be null") Integer id) {
        User user = userInterface.get(id);
        if (user == null) {
            return ResponseMessage.error("User with ID " + id + " not found", "User not found");
        }
        userInterface.delete(id);
        return ResponseMessage.success(null);
    }
}
