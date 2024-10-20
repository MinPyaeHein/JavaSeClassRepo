package com.jdbc_v3.dao;

import java.util.List;

public interface GeneralRepository<T> {
    T findById(int id);
    List<T> findAll();
    boolean save(T t);
    boolean update(T t);
    boolean deleteById(int id);
}
