package com.jdbc_v2.dao;

import com.jdbc_v2.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TeacherDao extends GeneralDao<Teacher>{

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
	
	public boolean createTeacherTable() {
		String createTableSql = "CREATE TABLE Teacher (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "phone VARCHAR(15), " +
                "address VARCHAR(255), " +
                "department VARCHAR(100), " +
                "position VARCHAR(50))";
		return execute(createTableSql);
	
	}

	 public boolean save(Teacher teacher){
	        String insertTableSQL = "INSERT INTO teacher (name, phone, address, department, position) VALUES"
	                + "(?,?,?,?,?)";
	        return execute(insertTableSQL,
	                 teacher.getName()
	                ,teacher.getPhone()
	                ,teacher.getAddress()
	                ,teacher.getDepartment()
	                ,teacher.getPosition());
	    }

	    public boolean update(Teacher teacher){
	        String updateTableSQL = "UPDATE teacher SET name=?, phone=?, address=?, department=?, position=? WHERE id=?";
	        return execute(updateTableSQL,
	                teacher.getName(),
	                teacher.getPhone(),
	                teacher.getAddress(),
	                teacher.getDepartment(),
	                teacher.getPosition(),
	                teacher.getId());
	    }
	    public boolean delete(int id){
	        String deleteTableSQL = "DELETE FROM teacher WHERE id=?";
	        return execute(deleteTableSQL, id);
	    }
	    public List<Teacher> getAll(){
	        String selectTableSQL = "SELECT * FROM teacher";
	        return executeQuery(selectTableSQL);
	    }

	}
