package com.assessment.demo.graphql;

import com.assessment.demo.dto.ItemDto;
import com.assessment.demo.service.ItemService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class FileQueryResolver implements GraphQLQueryResolver {
    
    private final ItemService service;

    public FileQueryResolver(ItemService service) {
        this.service = service;
    }

    public ItemDto fileMetadata(Long id) {

        return service.getFileMetadata(id);
    }
}
