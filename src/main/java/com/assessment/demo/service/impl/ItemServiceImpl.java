package com.assessment.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.demo.dto.ItemDto;
import com.assessment.demo.dto.PermissionDto;
import com.assessment.demo.mapper.ItemMapper;
import com.assessment.demo.model.Item;
import com.assessment.demo.model.ItemType;
import com.assessment.demo.model.Permission;
import com.assessment.demo.model.PermissionGroup;
import com.assessment.demo.model.PermissionLevel;
import com.assessment.demo.repository.ItemRepository;
import com.assessment.demo.service.ItemService;
import com.assessment.demo.service.PermissionService;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ItemMapper mapper;
    @Autowired
    PermissionService permissionService;

    public ItemServiceImpl(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;

    }

    @Override

    public ItemDto createItem(ItemDto dto, String userEmail){

        // Validation: If item is a SPACE, its parent should be null
        if(dto.getType().equals(ItemType.SPACE.toString())&& dto.getParentId()!=null){

            throw new IllegalArgumentException("A space item cannot have a parent.");
        }

        // Validation: If item is a FOLDER or FILE, it must have a parent
        if((dto.getType().equals(ItemType.FOLDER.toString())|| dto.getType().equals(ItemType.FILE.toString()))&&dto.getParentId()==null){
            throw new IllegalArgumentException("Folders and files must have a parent.");
        }

        // If the item has a parent
        if(dto.getParentId() !=null){
            Item parent= repository.findById(dto.getParentId())
            .orElseThrow(() -> new IllegalArgumentException("Parent item not found"));

            //Check the permission 
            PermissionGroup permissionGroup = parent.getPermissionGroup();
            Permission userPermission =permissionService.findPermission(userEmail, permissionGroup);
            
            if (userPermission == null) {
                throw new SecurityException("User does not belong to the permission group.");
            }

            if(userPermission.getPermissionLevel()!= PermissionLevel.EDIT){
                throw new SecurityException("User does not have permission to create this item.");
            }

            // Assign the parent's permission group to the new item
            dto.setPermissionGroupId(parent.getPermissionGroup().getId());

          

        

             // Add the item to the parent's children list
             Item childItem = mapper.toEntity(dto); // Convert DTO to entity
            parent.getChildren().add(childItem);   // Add the child to the parent's children

             // Save the parent (which will also save the child due to cascading)
             repository.save(parent);

            


        }
        // Save the new item
        Item savedItem = repository.save(mapper.toEntity(dto));
         return mapper.toDto(savedItem);
        
       



        
    }

    @Override
    public ItemDto getFileMetadata(Long fileId, String userEmail) {

        ItemDto metadata = repository.findFileMetadata(fileId, userEmail);
        if (metadata == null) {
            throw new RuntimeException("Access denied or file not found!");
        }
        return metadata;
    }


    @Override
    public ItemDto getFileMetadata(Long id){
        Optional<Item> itemOptional = repository.findById(id);

         return itemOptional.map(item -> new ItemDto(
            item.getId(),
            item.getName(),
            item.getType().name(),
            item.getParent() != null ? new ItemDto(item.getParent().getId(), item.getParent().getName(), item.getParent().getType().name(), null, null).getId()
            : null,
            null 
         )).orElse(null);
    }
  
   
}

