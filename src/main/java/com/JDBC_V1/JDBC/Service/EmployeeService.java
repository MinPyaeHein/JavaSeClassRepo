package com.JDBC_V1.JDBC.Service;

import com.JDBC.Dao.EmployeeDao_v1;
import com.JDBC_V1.JDBC.Dao.EmployeeDao;
import com.JDBC_V1.JDBC.Model.Employee;

import java.util.List;


public class EmployeeService {
    private EmployeeDao employeeDao;
    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }
    public String  addEmployee(Employee employee) {
        String message="";
        if(employeeDao.saveEmployee(employee)) {
            message = "Employee added successfully";
        } else {
            message = "Employee not added";
        }
        return message;
    }
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}
