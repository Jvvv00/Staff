package com.utar.staff.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "classicmodels")
public class User {
    @Id
    @Column(name = "username", nullable = false, length = 7)
    private String id;

    @Column(name = "password", nullable = false, length = 7)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}