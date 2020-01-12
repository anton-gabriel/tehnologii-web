package com.unitbv.resourcesmanager.service;

import com.unitbv.resourcesmanager.model.Role;
import com.unitbv.resourcesmanager.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/rest/role")
@RestController
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping(value="/all")
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
