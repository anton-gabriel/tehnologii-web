package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.model.Role;
import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import com.unitbv.resourcesmanager.repository.RoleRepository;
import com.unitbv.resourcesmanager.repository.UserRepository;
import com.unitbv.resourcesmanager.utils.enums.RightType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin/userDetails")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;


    @PostMapping
    @RequestMapping(value = "/removeRole/{roleId}")
    public String removeRole(@PathVariable("roleId") long id){
        Role target = roleRepository.getOne(id);
        roleRepository.delete(target);
        return "redirect:/admin/userDetails/{id}/";
    }


    @GetMapping
    public String map(Model model) {
        return "userDetails";
    }
}
