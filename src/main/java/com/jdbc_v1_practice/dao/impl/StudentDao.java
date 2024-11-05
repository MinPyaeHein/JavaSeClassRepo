package com.jdbc_v1_practice.dao.impl;

import com.jdbc_v1_practice.modal.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends GeneralDao5<Student> {

    public StudentDao() {
        super(Student.class);
    }

    @Override
    public Student convertToObject(ResultSet rs) {
        try {
            Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address")
            );
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert(Student student) {
        System.out.println("insert student customize");
        String sql = "INSERT INTO students (name, email, phone, address, major_id) VALUES (?,?,?,?,?)";
        executeUpdate(sql, student.getName(), student.getEmail(), student.getPhone(), student.getAddress(),student.getMajor().getId());
    }

}
