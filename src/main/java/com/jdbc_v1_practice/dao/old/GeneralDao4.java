package com.jdbc_v1_practice.dao.old;

import com.jdbc_v1_practice.annotation.Column;
import com.jdbc_v1_practice.annotation.Id;
import com.jdbc_v1_practice.annotation.Table;
import com.jdbc_v1_practice.dao.GeneralDao;
import com.jdbc_v1_practice.dao.impl.ConnectionDao;
import com.jdbc_v1_practice.util.DaoUtail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao4<T> implements GeneralDao<T> {
    public ConnectionDao connectionDao;
    private Class<T> classType;
    private String tableName;
    public GeneralDao4(Class<T> classType) {
        this.classType = classType;
        connectionDao = new ConnectionDao();
        this.tableName=classType.getAnnotation(Table.class).name();
    }
    public abstract T  convertToObject(ResultSet rs);
    //insert
    @Override
    public void insert(T obj) {
        String query=generateInsertQuery(obj);
        String idColumn=getColumnName(obj,"Id");
        executeUpdate( "insert",obj, query,idColumn);
    }

    @Override
    public void update(T obj,String... conductions) {
         String query=generateUpdateQuery(obj,conductions);
         executeUpdate("update",obj,query,conductions);

    }
    @Override
    //DElete Row
    public void delete(T obj) {
        String idColumn=getColumnName(obj,"Id");
        String sql = "DELETE FROM " + this.tableName +" WHERE "+idColumn+" = ?";
        System.out.println("Constructed Query: " + sql);
        executeUpdate("delete",obj,sql,"id");

    }
    @Override
    //select by id
    public T selectById(T obj) {
        List<T> list= null;
        try {
        String idColumn=getColumnName(obj,"Id");
        Field field=DaoUtail.getFieldsFromObj(obj,true,idColumn).get(0);
        field.setAccessible(true);
        System.out.println("Constructed Query: " + idColumn);
        String query  = "SELECT  * From " + this.tableName + " where "+idColumn+" = ?";
            list = executeQuerry(query, field.get(obj));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if(list!=null){
            return list.get(0);
        }
        return null;
    }
    @Override
    //select all
    public List<T> selectAll(){
        String sql = "SELECT * FROM " + this.tableName ;
        System.out.println(sql);
        return executeQuerry(sql);
    }

    private List<T> executeQuerry(String query,Object... values){
        List<T> list= new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement =  connection.prepareStatement(query);
            int count = 1;
            for (Object obj : values) {
                preparedStatement.setObject(count, obj);
                count++;
            }
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                list.add(convertToObject(rs));
            }
            rs.close();
            preparedStatement.close();
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
            if(!type.equals("delete")){
                    List<Field> columnFields=DaoUtail.getFieldsFromObj(obj,false ,conductions);
                for (Field field : columnFields) {
                    field.setAccessible(true);
                    preparedStatement.setObject(count, field.get(obj));
                    count++;
                }
            }
            if(type.equals("update")||type.equals("delete")){

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

        String query = "INSERT INTO " + this.tableName + " (";
        String idColumn=getColumnName(obj,"Id");
        System.out.println("id column=="+idColumn);
        List<Field> fields = DaoUtail.getFieldsFromObj(obj,false ,idColumn);
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

        String sql = "UPDATE " + this.tableName + " SET " ;
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

    private String getColumnName(Object obj,String annoType) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (annoType.equals("Id")) {
                if (field.isAnnotationPresent(Id.class)) {
                    Id id = field.getAnnotation(Id.class);
                    return id.name();
                }
            } else if (annoType.equals("Column")) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    return column.name();
                }
            }

        }
        return null;
    }
    }
