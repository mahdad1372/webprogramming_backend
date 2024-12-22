package com.example.web_programming_project.entities;


import jakarta.persistence.*;

@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer category_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Integer getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

