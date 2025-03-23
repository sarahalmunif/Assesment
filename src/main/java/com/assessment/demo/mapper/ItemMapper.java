package com.assessment.demo.mapper;

import com.assessment.demo.dto.ItemDto;
import com.assessment.demo.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(source = "permissionGroup.id", target = "permissionGroupId")
    @Mapping(source = "parent.id", target = "parentId")
    ItemDto toDto(Item item);

    @Mapping(source = "permissionGroupId", target = "permissionGroup.id")
    @Mapping(source = "parentId", target = "parent.id") 
    Item toEntity(ItemDto itemDto);
}