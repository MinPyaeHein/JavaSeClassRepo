package com.jdbc_v1_practice.dao.impl;

import com.jdbc_v1_practice.modal.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao extends GeneralDao5<Book> {

    public BookDao() {
        super(Book.class);
    }

    public void SaveBook(Book book){
            super.insert(book);
    }



    @Override
    public Book convertToObject(ResultSet rs) {
        try {
            return new Book(rs.getInt("book_id"),
                            rs.getString("name"),
                            rs.getString("author"),
                            rs.getString("description"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
