package com.assessment.demo.service;

import com.assessment.demo.dto.ItemDto;

public interface ItemService {

    ItemDto createItem(ItemDto dto, String userEmail);
    ItemDto getFileMetadata(Long fileId, String userEmail);
    ItemDto getFileMetadata(Long id);

 
    
}
