package com.assessment.demo.dto;

import lombok.Data;

@Data
public class PermissionDto {

    private Long id;
    private String userEmail;
    private String permissionLevel; // VIEW, EDIT
    private Long groupId;
    
    
}
