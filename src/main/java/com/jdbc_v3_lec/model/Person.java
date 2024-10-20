package com.jdbc_v3_lec.model;

import com.jdbc_v3_lec.annotation.Id;
import com.jdbc_v3_lec.annotation.Column;

public class Person {
    @Id(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    public Person() {
    }

    public Person(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Person(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        ", address='" + address + '\'';
    }
}