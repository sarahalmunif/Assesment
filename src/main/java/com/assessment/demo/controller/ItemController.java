package com.assessment.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.dto.ItemDto;
import com.assessment.demo.service.ItemService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ItemDto createItem(
        @RequestHeader("userEmail") String userEmail,
        @RequestBody ItemDto dto) {
        
            return service.createItem(dto, userEmail);

        
        
    }
    @GetMapping("/{fileId}")
    public ItemDto getItemMetaDate(
        @PathVariable Long fileId,
        @RequestHeader("userEmail") String userEmail) {

        return service.getFileMetadata(fileId,userEmail);

    }
    
    
    
}
