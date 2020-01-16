package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import com.unitbv.resourcesmanager.repository.UserRepository;
import com.unitbv.resourcesmanager.utils.enums.RightType;
import com.unitbv.resourcesmanager.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userRepository.getAllUserByType(UserRole.ROLE_USER);
    }

    @GetMapping
    public String map(Model model) {
        return "admin";
    }
}
