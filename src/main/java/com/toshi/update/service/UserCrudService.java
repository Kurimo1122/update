package com.toshi.update.service;

import com.toshi.update.model.User;
import com.toshi.update.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Service
public class UserCrudService {

    @Autowired
    EntityManager manager;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(Long id){
        List<User> results = manager.createNativeQuery("select * from user where id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
        User result = results.get(0);
        return result;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        List<User> results = manager.createNativeQuery("select * from user where id = :id", User.class)
                .setParameter("id", id)
                .getResultList();
        User result = results.get(0);
        userRepository.delete(result);
    }
}
