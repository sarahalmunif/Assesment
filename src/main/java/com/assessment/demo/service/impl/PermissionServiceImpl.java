package com.assessment.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.demo.dto.PermissionDto;
import com.assessment.demo.mapper.PermissionMapper;
import com.assessment.demo.model.Permission;
import com.assessment.demo.model.PermissionGroup;
import com.assessment.demo.repository.PermissionGroupRepository;
import com.assessment.demo.repository.PermissionRepository;
import com.assessment.demo.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    public PermissionServiceImpl(PermissionRepository repository, PermissionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;


    }

    @Override
    public PermissionDto createPermission(PermissionDto dto){

        // Save the entity to the repository (database)
        PermissionGroup group= permissionGroupRepository.findById(dto.getGroupId()).orElse(null);
         Permission permission=mapper.toEntity(dto);
         
            permission.setGroup(group);
        


        return mapper.toDto(this.repository.save(permission));

    }

    @Override
    public Permission findPermission(String userEmail, PermissionGroup group){
        
        // Find the permission using user email and permission group Id
        return  repository.findByUserEmailAndGroupId(userEmail, group.getId());

    }

    
}
