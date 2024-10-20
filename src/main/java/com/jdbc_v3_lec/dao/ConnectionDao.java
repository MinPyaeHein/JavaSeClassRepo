package com.jdbc_v3_lec.dao;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDao {
	public Connection connectionWithSqlDb() throws ClassNotFoundException, SQLException, IOException {
		InputStream fis=  getClass().getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		prop.load(fis);
		fis.close();
		
		String url= prop.getProperty("db.url");
		String user = prop.getProperty("db.user");
		String password= prop.getProperty("db.password");
		
		Connection c= DriverManager.getConnection(url,user,password);
		System.out.println(c!= null? "Connection established sucessfully": "Connection not establilshed");
		return c;
		
	}

}
