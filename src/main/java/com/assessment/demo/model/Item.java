package com.assessment.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)  // Store type as a readable String (SPACE, FOLDER, FILE)
    private ItemType type;

    private String name;

    @ManyToOne
    @JoinColumn(name = "permission_group_id")
    private PermissionGroup permissionGroup;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private Item parent;  // Self-referencing parent-child relationship

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Item> children = new ArrayList<>();
}