package com.utar.staff.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "offices", schema = "classicmodels")
@NamedQuery(name = "Office.findbyId", query = "SELECT o FROM Office o WHERE o.id = :id")
@NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")
public class Office {
    @Id
    @Column(name = "officecode", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city", nullable = false, length = 13)
    private String city;

    @Column(name = "phone", nullable = false, length = 16)
    private String phone;

    @Column(name = "addressline1", nullable = false, length = 24)
    private String addressline1;

    @Column(name = "addressline2", length = 9)
    private String addressline2;

    @Column(name = "state", length = 10)
    private String state;

    @Column(name = "country", nullable = false, length = 9)
    private String country;

    @Column(name = "postalcode", nullable = false, length = 8)
    private String postalcode;

    @Column(name = "territory", nullable = false, length = 5)
    private String territory;

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}