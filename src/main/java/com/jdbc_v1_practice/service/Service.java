package com.jdbc_v1_practice.service;

import java.util.List;

public interface Service<T>{
    public void save(T obj);
    public void update(T obj);
    public void delete(T obj);
    public List<T> getAll();
    public T getById(int id);

}
