package com.jdbc_v1_practice.dao.impl;

import com.jdbc_v1_practice.modal.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends GeneralDao4<Student> {

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

}
