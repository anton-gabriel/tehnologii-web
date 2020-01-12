package com.unitbv.resourcesmanager.repository;

import com.unitbv.resourcesmanager.model.Right;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RightRepository extends JpaRepository<Right, Long> {
    List<Right> findByName(String name);
}
