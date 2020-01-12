package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.*;
import com.unitbv.resourcesmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminController {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final RightRepository rightRepository;


    @Autowired
    public AdminController(UserRepository userRepository, ClientRepository clientRepository, RoleRepository roleRepository, RightRepository rightRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.rightRepository = rightRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());

        return "admin";
    }

    @GetMapping("role")
    public String showRoleForm(Model model) {
        model.addAttribute("resources", clientRepository.findAll());
        model.addAttribute("client", new Client());

        return "add-role";
    }

    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public String addRole(@ModelAttribute("client") Client student,
                          @RequestParam(value = "isCreated", required = false) Boolean isCreated,
                          @RequestParam(value = "isReaded", required = false) Boolean isReaded,
                          @RequestParam(value = "isUpdated", required = false) Boolean isUpdated,
                          @RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "add-role";
        }

        List<Right> rights = new ArrayList<>();
        if(isCreated != null){
            rights.add(rightRepository.findByName("CREATE").get(0));
        }
        if(isReaded != null){
            rights.add(rightRepository.findByName("READ").get(0));
        }
        if(isUpdated != null){
            rights.add(rightRepository.findByName("UPDATE").get(0));
        }
        if(isDeleted != null){
            rights.add(rightRepository.findByName("DELETE").get(0));
        }

        Role role = new Role();
        role.setClient(clientRepository.findById(student.getId()).get());
        role.setRights(rights);

        roleRepository.save(role);

        return "redirect:list";
    }

    @GetMapping("editUser/{id}")
    public String showUserForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        model.addAttribute("resources", clientRepository.findAll());

        return "adminResources";
    }

    @GetMapping("editResource/{id}")
    public String showResourceForm(@PathVariable("id") long id, Model model) {
        Client student = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        List<String> rights = new ArrayList<>();
        rights.add("CREATE");
        rights.add("READ");
        rights.add("UPDATE");
        rights.add("DELETE");

        model.addAttribute("client", student);
        model.addAttribute("rightsName", rights);

        return "adminRoles";
    }

    @GetMapping("editRights/{id}")
    public String showRightsForm(@PathVariable("id") long id, Model model) {
        Client student = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        List<String> rights = new ArrayList<>();
        rights.add("CREATE");
        rights.add("READ");
        rights.add("UPDATE");
        rights.add("DELETE");

        model.addAttribute("client", student);
        model.addAttribute("rightsName", rights);

        return "adminRoles";
    }

    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client student, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }

        clientRepository.save(student);
        model.addAttribute("students", clientRepository.findAll());
        return "user";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Client student = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        clientRepository.delete(student);
        model.addAttribute("students", clientRepository.findAll());
        return "user";
    }

    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        Client student = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        clientRepository.delete(student);
        model.addAttribute("students", clientRepository.findAll());
        return "user";
    }
}