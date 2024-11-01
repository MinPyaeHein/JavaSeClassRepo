package com.jdbc_v1_practice.dao.old;


import com.jdbc_v1_practice.dao.impl.ConnectionDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GeneralDao {
    private ConnectionDao connectionDao;
    public GeneralDao(){
        this.connectionDao=new ConnectionDao();
    }
    public abstract PreparedStatement getPreparedStatement(PreparedStatement preparedStatement,Object object);
    public void insert(String sql,Object object) throws SQLException{
        try {
            Connection c=connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement =c.prepareStatement(sql);
            preparedStatement=getPreparedStatement(preparedStatement,object);
            preparedStatement.execute();
            preparedStatement.close();
            c.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert(String sql, Object ...objects){
        try {
            Connection c=connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement =c.prepareStatement(sql);
            int count  =1;

            for(Object object :objects){
                    preparedStatement.setObject(count, objects);
                    count++;
            }
            preparedStatement.execute();
            preparedStatement.close();
            c.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
