package com.assessment.demo.mapper;

import org.mapstruct.Mapper;


import com.assessment.demo.dto.PermissionGroupDto;
import com.assessment.demo.model.PermissionGroup;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PermissionGroupMapper {


    PermissionGroupDto toDto(PermissionGroup entity);
    PermissionGroup toEntity(PermissionGroupDto dto);
}
