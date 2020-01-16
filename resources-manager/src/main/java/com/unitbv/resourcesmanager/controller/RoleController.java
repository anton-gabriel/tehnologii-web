package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.dto.RoleDto;
import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.model.Right;
import com.unitbv.resourcesmanager.model.Role;
import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import com.unitbv.resourcesmanager.repository.RoleRepository;
import com.unitbv.resourcesmanager.repository.UserRepository;
import com.unitbv.resourcesmanager.utils.enums.RightType;
import com.unitbv.resourcesmanager.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin/userDetails/{id}")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;


    @ModelAttribute("user")
    public User getUser(@PathVariable("id") long id){
        return userRepository.getOne(id);
    }

    @ModelAttribute("newRole")
    public RoleDto getNewRole() {
        return new RoleDto();
    }

    @ModelAttribute("existingRole")
    public RoleDto getExistingRole() {
        return new RoleDto();
    }

    @ModelAttribute("rightTypes")
    public List<RightType> getRightTypes() {
        return Arrays.asList(RightType.values());
    }

    @ModelAttribute("availableRoles")
    public List<Role> getAvailableRoles() {
        return roleRepository.findAll();
    }

    @ModelAttribute("availableResource")
    public List<Client> getAvailableResources() {
        return clientRepository.findAll();
    }

    @PostMapping(value = "/createRole")
    public String addRole(@ModelAttribute("newRole") @Valid RoleDto roleDto,
                          @PathVariable("id") long id){
        User desiredUser = userRepository.getOne(id);
        RightType rightType = roleDto.getRightType();
        Role desiredRole = new Role();
        Right desiredRight = new Right();
        desiredRight.setName(rightType);
        desiredRight.setClient(clientRepository.getClientByEmail(roleDto.getResourceName()).get());
        desiredRole.getRights().add(desiredRight);

        desiredUser.getRoles().add(desiredRole);
        desiredRole.getUsers().add(desiredUser);

        roleRepository.save(desiredRole);
        userRepository.save(desiredUser);

        return "redirect:/admin/userDetails/{id}/";
    }

    @PostMapping(value = "/setRole")
    public String setRole(@ModelAttribute("existingRole") @Valid RoleDto roleDto,
                          @PathVariable("id") long id){
        User desiredUser = userRepository.getOne(id);
        Role desiredRole = roleRepository.getOne(roleDto.getId());

        desiredRole.getUsers().add(desiredUser);
        desiredUser.getRoles().add(desiredRole);

        roleRepository.save(desiredRole);
        userRepository.save(desiredUser);

        return "redirect:/admin/userDetails/{id}/";
    }


    @PostMapping(value = "/remove/{roleId}")
    public String removeRole(@PathVariable("roleId") long roleId, @PathVariable("id") long userId){
        Role targetRole = roleRepository.getOne(roleId);
        User targetUser = userRepository.getOne((userId));
        if(targetUser.getRoles() == null){
            return "redirect:/admin/userDetails/{id}/";
        }
        targetUser.getRoles().remove(targetRole);
        targetRole.getUsers().remove(targetUser);
        userRepository.save(targetUser);
        roleRepository.save(targetRole);
        return "redirect:/admin/userDetails/{id}/";
    }


    @GetMapping
    public String map(Model model) {
        return "userDetails";
    }
}
