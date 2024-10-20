package com.jdbc_v3.dao;
import com.jdbc_v3.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDao extends GeneralDao<Employee> {

	public EmployeeDao() {
		super(Employee.class);  // Pass the class type to the super class
	}

	@Override
	public Employee convertToObject(ResultSet rs) throws SQLException {
		return new Employee(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("phone"),
				rs.getString("address")
		);
	}
}

	



	
	

