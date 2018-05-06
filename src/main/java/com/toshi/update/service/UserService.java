package com.toshi.update.service;

import com.toshi.update.model.User;
import com.toshi.update.dto.UserRegistrationDto;
import com.toshi.update.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}