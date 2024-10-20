package com.jdbc_v3_lec.model;

import com.jdbc_v3_lec.annotation.Table;

@Table(name = "employees")
public class Employee extends Person {

    public Employee(String name, String phone, String address) {
        super(name, phone, address);
    }
    public Employee(int id, String name, String phone, String address) {
        super(id, name, phone, address);

    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                '}';
    }
}