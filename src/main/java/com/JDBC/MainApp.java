package com.JDBC;

import com.JDBC.Dao.EmployeeDao_v1;
import com.JDBC.Model.Employee;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       EmployeeDao dao = new EmployeeDao();
//       dao.updateEmployee(new Employee(7,"Ni Ni", "1234567890", "123 Main St"));
//       dao.updateEmployee(new Employee(6,"Arabelle", "1234567890", "123 Main St"));
//       dao.deleteEmployee(5);
//       for (Employee employee : dao.getEmployees()) System.out.println(employee); //dao.getEmployees()
dao.createTeacherTable();


    }
}
