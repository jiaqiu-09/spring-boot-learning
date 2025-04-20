package com.scania.spring_boot_learning.service;

import com.scania.spring_boot_learning.pojo.User;
import com.scania.spring_boot_learning.pojo.dto.UserDto;
import com.scania.spring_boot_learning.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        final User user1 = userRepository.save(userPojo);
        System.out.println("User added: " + user1);
        return user1;
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User edit(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        final User user1 = userRepository.save(userPojo);
        System.out.println("User updated: " + user1);
        return user1;
    }
}
