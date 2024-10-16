package com.JDBC_V1.JDBC.Dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao<T> {
    private ConnectionDao connectionDao;
    public GeneralDao() {
        this.connectionDao =new ConnectionDao();
    }
    public boolean execute(String sql, Object ...value) {
        boolean result = false;
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            PreparedStatement preparedStatement =c.prepareStatement(sql);
            int index=1;
            if(value!=null && value.length>=1){
                for(Object v:value){
                    preparedStatement.setObject(index++, v);
                }
            }
            preparedStatement.execute();
            preparedStatement.close();
            c.close();
            result = true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      return result;
    }
    public abstract T convertToGenericObj(ResultSet rs);
    public List<T> executeQuery(String query){
        List<T> objects = null;
        try {
            Connection c=this.connectionDao.connectionWithPgSqlDb2();
            Statement statement =c.createStatement();
            ResultSet rs = statement.executeQuery(query);
            objects = new ArrayList<T>();
            while (rs.next()) {
                objects.add(convertToGenericObj(rs));

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
