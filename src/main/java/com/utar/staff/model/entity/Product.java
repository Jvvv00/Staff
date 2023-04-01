package com.utar.staff.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "classicmodels")
public class Product {
    @Id
    @Column(name = "productcode", nullable = false, length = 9)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}