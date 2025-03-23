package com.assessment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.demo.dto.ItemDto;
import com.assessment.demo.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


    @Query(value = """
        SELECT i.id AS id, i.name AS fileName, i.type AS fileType, pg.group_name AS permissionGroup
        FROM item i
        JOIN permission_group pg ON i.permission_group_id = pg.id
        JOIN permission p ON p.group_id = pg.id
        WHERE i.id = :fileId AND p.user_email = :userEmail
        LIMIT 1
    """, nativeQuery = true)
    ItemDto findFileMetadata(@Param("fileId") Long fileId, @Param("userEmail") String userEmail);

}