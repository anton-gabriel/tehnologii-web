package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import com.unitbv.resourcesmanager.repository.RoleRepository;
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
@RequestMapping("admin/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @ModelAttribute("user")
    public User getUser(Model model){
        return (User) model.getAttribute("user");
    }

    @ModelAttribute("rightTypes")
    public List<RightType> getRightTypes() {
        List<RightType> rightTypes =  Arrays.asList(RightType.values());
        return rightTypes;
    }

    @ModelAttribute("availableResource")
    public List<Client> getAvailableResources() {
        return clientRepository.findAll();
    }

    @GetMapping
    public String map(Model model) {
        return "roles";
    }
}
