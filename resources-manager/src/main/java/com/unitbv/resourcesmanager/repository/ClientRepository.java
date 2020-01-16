package com.unitbv.resourcesmanager.repository;

import com.unitbv.resourcesmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> getClientByEmail(String email);
}
