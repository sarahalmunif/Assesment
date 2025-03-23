package com.assessment.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.dto.PermissionDto;
import com.assessment.demo.service.PermissionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public PermissionDto createPermission(@RequestBody PermissionDto dto) {
        
        
        return this.service.createPermission(dto);
    }
    


    
}
