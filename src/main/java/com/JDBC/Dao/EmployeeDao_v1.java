package com.JDBC.Dao;

import com.JDBC.Model.Employee;
import com.JDBC.Model.Teacher;

import java.sql.*;
import java.util.List;

public class EmployeeDao_v1 extends GeneralDao<Employee> {

    public EmployeeDao_v1() {

    }
    @Override
    public Employee convertToGenericObj(ResultSet rs) {
        try {
            return new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("address"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean saveEmployee(Employee employee){
        String insertTableSQL = "INSERT INTO employee (name, phone, address) VALUES"
                + "(?,?,?)";
        return execute(insertTableSQL, employee.getName(),employee.getPhone(),employee.getAddress());
    }

    public boolean updateEmployee(Employee employee){
        String updateTableSQL = "UPDATE employee SET name=?, phone=?, address=? WHERE id=?";
        return execute(updateTableSQL, employee.getName(),employee.getPhone(),employee.getAddress(),employee.getId());
    }
    public boolean deleteEmployee(int id){
        String deleteTableSQL = "DELETE FROM employee WHERE id=?";
        return execute(deleteTableSQL, id);
    }
    public List<Employee> getEmployees(){
        String selectTableSQL = "SELECT * FROM employee";
        return executeQuery(selectTableSQL);
    }
    Teacher t=new Teacher();

}
