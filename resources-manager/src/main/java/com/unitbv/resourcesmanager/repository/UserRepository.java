package com.unitbv.resourcesmanager.repository;

import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.utils.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    List<User> getAllUserByType(UserRole type);
}
