package com.scania.spring_boot_learning.repository;

import com.scania.spring_boot_learning.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
