package com.assessment.demo.service.impl;
import org.springframework.stereotype.Service;

import com.assessment.demo.dto.PermissionGroupDto;
import com.assessment.demo.mapper.PermissionGroupMapper;
import com.assessment.demo.model.PermissionGroup;
import com.assessment.demo.repository.PermissionGroupRepository;
import com.assessment.demo.service.PermissionGroupService;

@Service
public class PermissionGroupServiceImpl implements PermissionGroupService  {


    private final PermissionGroupRepository repository;
    private final PermissionGroupMapper mapper;

    public PermissionGroupServiceImpl(PermissionGroupRepository repository, PermissionGroupMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PermissionGroupDto createPermissionGroup(PermissionGroupDto dto){
        
       PermissionGroup group = new PermissionGroup();
        group.setGroupName(dto.getGroupName());

        if (dto.getGroupName() == null || dto.getGroupName().isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be null or empty");
        }
        
        // Save the entity to the repository (database)
        return mapper.toDto(this.repository.save(group));

        
    }





    
}
