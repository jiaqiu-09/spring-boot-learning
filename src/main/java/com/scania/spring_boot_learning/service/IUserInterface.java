package com.scania.spring_boot_learning.service;

import com.scania.spring_boot_learning.pojo.User;
import com.scania.spring_boot_learning.pojo.dto.UserDto;

public interface IUserInterface {
    /**
     * Add a new user
     *
     * @param user
     * @return
     */
    User add(UserDto user);
}
