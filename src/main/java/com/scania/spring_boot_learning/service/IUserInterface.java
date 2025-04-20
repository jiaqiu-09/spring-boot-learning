package com.scania.spring_boot_learning.service;

import com.scania.spring_boot_learning.pojo.User;
import com.scania.spring_boot_learning.pojo.dto.UserDto;
import jakarta.validation.constraints.NotNull;

public interface IUserInterface {
    /**
     * Add a new user
     *
     * @param user
     * @return
     */
    User add(UserDto user);

    /**
     * Get user by id
     *
     * @param id
     * @return
     */
    User get(Integer id);

    /**
     * Delete user by id
     *
     * @param id
     */
    void delete(@NotNull(message = "User ID cannot be null") Integer id);

    /**
     * Update user
     *
     * @param user
     * @return
     */
    User edit(UserDto user);
}
