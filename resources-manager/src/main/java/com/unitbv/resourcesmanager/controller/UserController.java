package com.unitbv.resourcesmanager.controller;


import com.unitbv.resourcesmanager.dto.ClientDto;
import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.model.Role;
import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import com.unitbv.resourcesmanager.repository.RoleRepository;
import com.unitbv.resourcesmanager.repository.UserRepository;
import com.unitbv.resourcesmanager.utils.enums.RightType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @ModelAttribute("loggedUser")
    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findUserByUsername(auth.getName()).get();
    }

    @ModelAttribute("clientDto")
    public ClientDto getDtoClient(){
        return new ClientDto();
    }

    @ModelAttribute("readableClients")
    public List<Client> getReadableClients(@ModelAttribute("loggedUser") User user) {
        return user.getRoles().stream()
                .flatMap(role -> role.getRights().stream())
                .filter(right -> right.getName() == RightType.READ)
                .map(right -> right.getClient())
                .collect(Collectors.toList());
    }

    @ModelAttribute("modifiableClients")
    public List<Client> getModifiableClients(@ModelAttribute("loggedUser") User user) {
        return user.getRoles().stream()
                .flatMap(role -> role.getRights().stream())
                .filter(right -> right.getName() == RightType.MODIFY)
                .map(right -> right.getClient())
                .collect(Collectors.toList());
    }

    @ModelAttribute("deletableClients")
    public List<Client> getDeletableClients(@ModelAttribute("loggedUser") User user) {
        return user.getRoles().stream()
                .flatMap(role -> role.getRights().stream())
                .filter(right -> right.getName() == RightType.DELETE)
                .map(right -> right.getClient())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/modify/{clientId}")
    public  String modifyClient(@ModelAttribute("clientDto") ClientDto clientDto,
                                @PathVariable("clientId") long clientId)
    {
        Client client = clientRepository.getOne(clientId);
        client.setEmail(clientDto.getEmail());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        clientRepository.save(client);
        return "redirect:/user";
    }

    @PostMapping(value = "/delete/{clientId}")
    public  String deleteClient(@ModelAttribute("clientDto") ClientDto clientDto,
                                @PathVariable("clientId") long clientId)
    {
        Client client = clientRepository.getOne(clientId);
        client.setActive(false);
        clientRepository.save(client);
        return "redirect:/user";
    }

    @GetMapping
    public String map(Model model) {
        return "user";
    }
}
