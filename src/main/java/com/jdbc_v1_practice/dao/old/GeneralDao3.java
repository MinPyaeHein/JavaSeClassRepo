package com.jdbc_v1_practice.dao.old;

import com.jdbc_v1_practice.dao.impl.ConnectionDao;
import com.jdbc_v1_practice.util.DaoUtail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao3<T> {
    public ConnectionDao connectionDao;

    public GeneralDao3() {
        connectionDao = new ConnectionDao();
    }
    public abstract T  convertToObject(ResultSet rs);
    //insert
    public void insert(Object obj) {
        String query=generateInsertQuery(obj);
        executeUpdate( "insert",obj, query,null,"id");
    }


    public void update(T obj) {
         String query=generateUpdateQuery(obj,"name","email");
         executeUpdate("update",obj,query,"name","email");

    }

    //DElete Row
    public Boolean deleteRow(T className,int id) {
        String tableName = className.getClass().getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName +" WHERE id = ?";
        System.out.println("Constructed Query: " + sql);
        Connection connection = null;
        try {
            connection = connectionDao.connectionWithSqlDb();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int rowEffected = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if(rowEffected > 0) {
           return true;
        }else {
           return false;
        }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //select by id
    public T selectById(T className,int id) {
        String tableName = className.getClass().getSimpleName().toLowerCase();
        String sql  = "SELECT  * From " + tableName + " where id = ?";
        T object = null;
        System.out.println(sql);
        Connection connection= null;
        try {
            connection = connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                object = (convertToObject(resultSet));
            }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return object;
    }

    //select all
    public List<T> selectAll(T className){
        String tableName = className.getClass().getSimpleName().toLowerCase();

        List<T> list= new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        System.out.println(sql);
        Connection connection = null;
        try {
            connection = connectionDao.connectionWithSqlDb();

        Statement statment = connection.createStatement();
        ResultSet rs = statment.executeQuery(sql);
        while(rs.next()) {
            list.add(convertToObject(rs));
        }
        rs.close();
        statment.close();
        connection.close();
        return list;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //insert,update,delete
    private void executeUpdate(String type,Object obj,String query,String... conductions){
        try {
            Connection connection = connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int count = 1;
            List<Field> columnFields=DaoUtail.getFieldsFromObj(obj,false ,conductions);
            for (Field field : columnFields) {
                field.setAccessible(true);
                preparedStatement.setObject(count, field.get(obj));
                count++;
            }
            if(type.equals("update")){

                List<Field> conductionFields=DaoUtail.getFieldsFromObj(obj,true,conductions);
                for(Field field:conductionFields){
                    field.setAccessible(true);
                    preparedStatement.setObject(count, field.get(obj));
                    count++;
                }
            }
            int rowAffect = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateInsertQuery(Object obj){
        String tableName = obj.getClass().getSimpleName().toLowerCase();
        String query = "INSERT INTO " + tableName + " (";
        List<Field> fields = DaoUtail.getFieldsFromObj(obj,false ,"id");
        for (Field field : fields) {
            field.setAccessible(true);
            query += field.getName() + ", ";
        }
        query = query.substring(0, query.length() - 2);
        query += ") VALUES (";
        for (Field field :fields) {
            query += "?, ";
        }
        query = query.substring(0, query.length() - 2);
        query += ")";
        System.out.println("Constructed Query: " + query);
       return query;
    }
    private String generateUpdateQuery(Object obj,String... conductions){
        String tableName = obj.getClass().getSimpleName().toLowerCase();
        String sql = "UPDATE " + tableName + " SET " ;
        List<Field> updateFields = DaoUtail.getFieldsFromObj(obj,false,conductions);

        for(Field field: updateFields) {
            field.setAccessible(true);
            sql += field.getName() + " = ?, ";
            }
        sql = sql.substring(0,sql.length() - 2);
        sql += " WHERE ";
        for (String conduction: conductions ){
            sql +=conduction+" = ? and ";
        }
        sql = sql.substring(0,sql.length() - 4);
        System.out.println("Constructed Query: " + sql);
        return sql;
    }




}
