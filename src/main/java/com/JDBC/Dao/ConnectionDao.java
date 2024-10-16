package com.JDBC.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDao {
    public void connectionWithPgSqlDb() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/EmployeeDb?user=postgres&password=root");
        System.out.println(c!=null?"Connection established successfully":"Connection not established");
        c.close();
    }
    public void connectionWithPgSqlDb1() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    Connection c= DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/EmployeeDb",
            "postgres",
            "root");
    System.out.println(c!=null?"Connection established successfully":"Connection not established");
    c.close();
   }
    public Connection connectionWithPgSqlDb2() throws ClassNotFoundException, SQLException, IOException {
      InputStream fis=getClass().getClassLoader().getResourceAsStream("db.properties");
      Properties prop=new Properties();
      prop.load(fis);
      fis.close();
      String url=prop.getProperty("db.url");
      String user=prop.getProperty("db.user");
      String password=prop.getProperty("db.password");
      Connection c= DriverManager.getConnection(url,user,password);
      System.out.println(c!=null?"Connection established successfully":"Connection not established");
      return c;


    }


}
