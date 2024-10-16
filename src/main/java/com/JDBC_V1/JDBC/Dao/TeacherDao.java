package com.JDBC_V1.JDBC.Dao;

import com.JDBC_V1.JDBC.Model.Employee;
import com.JDBC_V1.JDBC.Model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeacherDao extends GeneralDao<Teacher> {

    public TeacherDao() {

    }
    @Override
    public Teacher convertToGenericObj(ResultSet rs) {
        try {
            return new Teacher(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("department"),
                    rs.getString("position"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    Teacher t=new Teacher();

}
