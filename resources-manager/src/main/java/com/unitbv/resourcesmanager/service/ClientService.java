package com.unitbv.resourcesmanager.service;

import com.unitbv.resourcesmanager.model.Client;
import com.unitbv.resourcesmanager.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void SaveClient(Client client){
        clientRepository.save(client);
    }

}