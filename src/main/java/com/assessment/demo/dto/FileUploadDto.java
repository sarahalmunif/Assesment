package com.assessment.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class FileUploadDto {
    

    private Long itemId;
    private MultipartFile file; 
}
