package com.jdbc_v3_lec.dao;

import com.jdbc_v3_lec.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDao extends GeneralDao<Employee> {
	public EmployeeDao() {
        super(Employee.class);
    }
	private ConnectionDao connectionDao;

	@Override
	public Employee convertToObject(ResultSet rs) {
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
	
	public boolean createEmployeTable(){
		String createEmployeeTableSql = "CREATE TABLE Employee (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "phone VARCHAR(15), " +
                "address VARCHAR(255))";
		return execute(createEmployeeTableSql);
		
	}
		  
	public boolean saveEmployee(Employee employee) {
		String insertTableSQL = "INSERT INTO employee (name, phone, address) VALUES" + "(?,?,?)";
		return execute(insertTableSQL, employee.getName(), employee.getPhone(),employee.getAddress());
	}
	
	public boolean updateEmployee(Employee employee) {
        String updateTableSQL = "UPDATE employee SET name=?, phone = ?, address =? WHERE id=?";
        return execute(updateTableSQL, employee.getName(), employee.getPhone(), employee.getAddress());
    
	}
	
	public boolean deleteEmployee(int id) {
		String deleteTableSQL = "DELETE FROM employee WHERE id=?";
		return execute(deleteTableSQL,id);
    
	}
	public Employee getEmployeeById(int id) {
		String selectTableSQL = "SELECT * FROM employee WHERE id=?";
        return executeQuery(selectTableSQL, id).get(0);
	}
	



	
}
	



	
	

