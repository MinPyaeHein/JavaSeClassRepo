package com.jdbc_v1_practice.dao;

import java.util.List;

public interface GeneralDao<T>{
    public void insert(T obj);
    public void update(T obj,String... conductions);
    public void delete(T obj);
    public T selectById(int id);
    public List<T> selectAll();

}
