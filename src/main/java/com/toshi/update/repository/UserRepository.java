package com.toshi.update.repository;

import com.toshi.update.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
//    User findOne(String name);
}
