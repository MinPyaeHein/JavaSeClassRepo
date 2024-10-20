package com.jdbc_v3_lec.dao;

import com.jdbc_v3.Util.ReflectionUtil;
import com.jdbc_v3_lec.Util.Util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralDao<T> {
	private ConnectionDao connectionDao;
	private Class<T> currentEntity;
	public abstract T convertToObject(ResultSet rs);
	

	public GeneralDao(Class<T> currentEntity) {
		this.currentEntity = currentEntity;
		this.connectionDao = new ConnectionDao();
	}
	
	//execute
	public boolean execute(String sql, Object ...value) {
		boolean result = false;
		try {
			Connection c = this.connectionDao.connectionWithSqlDb();
			PreparedStatement preparedStatement = c.prepareStatement(sql);
			int index = 1;
			if(value!=null && value.length >=1) {
				for(Object v: value) {
					preparedStatement.setObject(index++,v);
				}
			}
			preparedStatement.execute();
			preparedStatement.close();
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
	public List<T>  executeQuery(String sql, Object ...value) {
		boolean result = false;
		List<T> objects = null;
		try {
			Connection c = this.connectionDao.connectionWithSqlDb();
			PreparedStatement preparedStatement = c.prepareStatement(sql);
			int index = 1;
			if(value!=null && value.length >=1) {
				for(Object v: value) {
					preparedStatement.setObject(index++,v);
				}
			}
			ResultSet rs=preparedStatement.executeQuery();
			objects = new ArrayList<T>();
			while(rs.next()) {
				objects.add(convertToObject(rs));
			}
			preparedStatement.close();
			result = true;

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return objects;
	}
	
    public List<T> getAll(){
		String sql = "SELECT * FROM "+(this.currentEntity.getSimpleName().toLowerCase());
		List<T> objects = executeQuery(sql);

		return objects;
	}
	public void updateTest(T entity){
		String sql = "UPDATE "+(this.currentEntity.getSimpleName().toLowerCase())+" SET ";
		List<String> fields = Util.getAllColumnField(entity.getClass());

		for(String field : fields){
			sql+=field+"=?, ";
		}
		sql=sql.substring(0, sql.length()-2);
		sql+=" WHERE "+ Util.getAllIdField(entity.getClass()).get(0)+"=?";
		System.out.println(sql);
        execute(sql,Util.getFieldValues(entity));
	}



	}
	
	


