package com.jdbc_v1_practice.dao.old;


import com.jdbc_v1_practice.dao.impl.ConnectionDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao1<T> {
    private ConnectionDao connectionDao;
    public GeneralDao1(){
        this.connectionDao=new ConnectionDao();
    }
    public abstract PreparedStatement getPreparedStatement(PreparedStatement preparedStatement,T object);
    public void insert(String sql,T object) throws SQLException{
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
    public abstract T resultSetToObjConvector(ResultSet resultSet);
    public List<T> getAll(String sql){
        try {
            List<T> list = new ArrayList<T>();
            Connection c=connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement=c.prepareStatement(sql);
            ResultSet resultSet =preparedStatement.executeQuery();
            while(resultSet.next()){
                T t=resultSetToObjConvector(resultSet);
                list.add(t);
            }
            return list;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
