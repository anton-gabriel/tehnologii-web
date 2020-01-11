package com.unitbv.resourcesmanager.repository;

import com.unitbv.resourcesmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
