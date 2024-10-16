package com.JDBC;

import com.JDBC.Dao.ConnectionDao;
import com.JDBC.Dao.GeneralDao;
import com.JDBC.Model.Employee;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private ConnectionDao connectionDao;
    private GeneralDao generalDao;
    public EmployeeDao() {
        this.connectionDao =new ConnectionDao();
    }
    public boolean createEmployeeTable(){
        String createTableSQL = "CREATE TABLE employee ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "phone VARCHAR(15), "
                + "address TEXT)";
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            Statement statement =c.createStatement();
            statement.execute(createTableSQL);
            statement.close();
            c.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean createTeacherTable(){
        String createTableSQL = "CREATE TABLE teacher ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "phone VARCHAR(15), "
                + "department VARCHAR(15), "
                + "position VARCHAR(15), "
                + "address TEXT)";
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            Statement statement =c.createStatement();
            statement.execute(createTableSQL);
            statement.close();
            c.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean saveEmployee(){
        boolean result = false;
        String insertTableSQL = "INSERT INTO employee (name, phone, address) VALUES"
                + "('John Doe', '1234567890', '123 Main St')";
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            Statement statement =c.createStatement();
            result=statement.execute(insertTableSQL);
            statement.close();
            c.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public boolean saveEmployee(Employee employee){
        boolean result = false;
        String insertTableSQL = "INSERT INTO employee (name, phone, address) VALUES"
                + "(?,?,?)";
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            PreparedStatement preparedStatement =c.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPhone());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.execute();
            c.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<Employee> getEmployees(){
        List<Employee> employees = null;
        String selectTableSQL = "SELECT * FROM employee";
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            Statement statement =c.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            employees = new ArrayList<Employee>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                employees.add(new Employee(id, name, phone, address));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }


}
