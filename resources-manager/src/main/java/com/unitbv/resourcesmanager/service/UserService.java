package com.unitbv.resourcesmanager.service;

import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username, String password, String type){
        for (User user: userRepository.findAll()) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password) && user.getType().equals(type))
                return user;
        }

        return null;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for(User user: userRepository.findAll()){
            if(user.getType().equals("user"))
                users.add(user);
        }

        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
