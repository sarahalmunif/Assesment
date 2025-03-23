package com.assessment.demo.service;

import java.util.List;

import com.assessment.demo.dto.PermissionDto;
import com.assessment.demo.model.Permission;
import com.assessment.demo.model.PermissionGroup;

public interface PermissionService {
    
    PermissionDto createPermission(PermissionDto dto);
    Permission findPermission(String userEmail, PermissionGroup group);
}
