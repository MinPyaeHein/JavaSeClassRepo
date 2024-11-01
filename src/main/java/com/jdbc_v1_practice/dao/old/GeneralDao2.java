package com.jdbc_v1_practice.dao.old;


import com.jdbc_v1_practice.dao.impl.ConnectionDao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao2<T> {
    private ConnectionDao connectionDao;
    public GeneralDao2(){
        this.connectionDao=new ConnectionDao();
    }
    public void insert(T object) {
        String sql="insert into " +object.getClass().getSimpleName().toLowerCase() + "(";
             for(Field field:object.getClass().getDeclaredFields()){
                 if(!field.getName().equals("id")){
                     sql+=field.getName()+",";
                 }
             }
             sql=sql.substring(0,sql.length()-1) + ") values(";
          try {
              List<Object> values=new ArrayList<Object>();
             for(Field field:object.getClass().getDeclaredFields()){
                 if(!field.getName().equals("id")){
                 field.setAccessible(true);
                 values.add(field.get(object));
                 sql+="?,";
                 }
             }
             sql=sql.substring(0,sql.length()-1) + ");";
             System.out.println(sql);

                Connection c=connectionDao.connectionWithSqlDb();
                PreparedStatement preparedStatement =c.prepareStatement(sql);
                for(int i=0;i<values.size();i++){
                    System.out.println(values.get(i));
                    preparedStatement.setObject(i+1, values.get(i));
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
            } catch (IllegalAccessException e) {
              throw new RuntimeException(e);
          }
    }
    public void update(T object) {
        String sql = "update " + object.getClass().getSimpleName().toLowerCase() + " set ";
        for (Field field : object.getClass().getDeclaredFields()) {
            if (!field.getName().equals("id")) {
                sql += field.getName() + "=?,";
            }
        }
        try {
        Field id=object.getClass().getDeclaredField("id");
        id.setAccessible(true);
        String idValue=id.get(object)+"";
        sql = sql.substring(0, sql.length() - 1) + " where id="+idValue+";";
            List<Object> values = new ArrayList<Object>();
            for (Field field : object.getClass().getDeclaredFields()) {
                if (!field.getName().equals("id")) {
                    field.setAccessible(true);
                    values.add(field.get(object));

                }
            }

            sql = sql.substring(0, sql.length() - 1)+";";
            System.out.println(sql);
            Connection c=connectionDao.connectionWithSqlDb();
            PreparedStatement preparedStatement =c.prepareStatement(sql);
            for(int i=0;i<values.size();i++){
                System.out.println(values.get(i));
                preparedStatement.setObject(i+1, values.get(i));
            }
            preparedStatement.execute();
            preparedStatement.close();
            c.close();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    


    }
