package com.assessment.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.dto.PermissionGroupDto;
import com.assessment.demo.service.PermissionGroupService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/permission-groups")
public class PermissionGroupController {



     private final PermissionGroupService service;

    public PermissionGroupController(PermissionGroupService service) {
        this.service = service;
    }

    @PostMapping
    public PermissionGroupDto createPermissionGroup(@RequestBody PermissionGroupDto dto) {
    
        
        return this.service.createPermissionGroup(dto);
    }
    
    
}
