package com.assessment.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.demo.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByUserEmailAndGroupId(String userEmail,Long groupId);
   // List<Permission> findAllByUserEmailAndGroupId(String userEmail,Long groupId);


}
