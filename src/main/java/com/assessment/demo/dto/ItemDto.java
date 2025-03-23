package com.assessment.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemDto {
    
    private Long id;
    private String name;
    private String type;
    private Long parentId; 
    private Long permissionGroupId;

    // Constructor matching the query result
    public ItemDto(Long id, String fileName, String fileType, String permissionGroup) {
        this.id = id;
        this.name = fileName;          // fileName maps to name
        this.type = fileType;          // fileType maps to type            this.permissionGroupId = null; // Set this based on your logic (if applicable)
        }
    
}
