package com.assessment.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.assessment.demo.dto.PermissionDto;
import com.assessment.demo.model.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    
    @Mapping(source = "group.id", target = "groupId")
    PermissionDto toDto(Permission permission);
    @Mapping(source = "groupId", target = "group.id")
    Permission toEntity(PermissionDto permissionDto);
}