package com.JDBC;

import com.JDBC.Model.Employee;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       EmployeeDao dao = new EmployeeDao();
//       dao.saveEmployee(new Employee("Michael","0974745745","Yango"));
//       dao.saveEmployee(new Employee("Shine","0974745745","Yango"));
//       dao.saveEmployee(new Employee("Soe","0974745745","Yango"));

       for(Employee emp:dao.getEmployees()){
           System.out.println(emp);
       }

    }
}
