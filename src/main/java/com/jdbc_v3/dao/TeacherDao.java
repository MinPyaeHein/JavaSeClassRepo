package com.jdbc_v3.dao;

import com.jdbc_v3.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TeacherDao extends GeneralDao<Teacher> {
	public TeacherDao() {
		super(Teacher.class);  // Pass the class type to the super class
	}
	@Override
	public Teacher convertToObject(ResultSet rs) {
		try {
			return new Teacher(
					 rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("phone"),
	                    rs.getString("address"),
	                    rs.getString("department"),
	                    rs.getString("position"));
		}catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	}
