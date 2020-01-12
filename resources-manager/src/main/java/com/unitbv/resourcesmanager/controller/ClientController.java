package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students/")
public class ClientController {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("create")//signup
    public String showClientCreateForm(Client client) {
        return "add-client";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("students", clientRepository.findAll());
        return "client";//user
    }

    @PostMapping("add")
    public String addStudent(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-client";//add-student
        }
        clientRepository.save(client);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client    = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "update-client";
    }

    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "update-client";
        }

        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "user";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        clientRepository.delete(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "client";
    }
}
