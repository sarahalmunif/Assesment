package com.assessment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.demo.model.PermissionGroup;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
}
