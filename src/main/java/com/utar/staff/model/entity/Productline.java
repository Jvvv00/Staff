package com.utar.staff.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productlines", schema = "classicmodels")
public class Productline {
    @Id
    @Column(name = "productline", nullable = false, length = 16)
    private String id;

    @Column(name = "textdescription", length = 735)
    private String textdescription;

    @Column(name = "htmldescription", length = 1)
    private String htmldescription;

    @Column(name = "image", length = 10)
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}