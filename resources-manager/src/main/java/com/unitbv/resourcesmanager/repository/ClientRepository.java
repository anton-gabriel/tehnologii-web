package com.unitbv.resourcesmanager.repository;

import com.unitbv.resourcesmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
