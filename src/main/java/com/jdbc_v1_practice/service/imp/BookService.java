package com.jdbc_v1_practice.service.imp;

import com.jdbc_v1_practice.dao.impl.BookDao;
import com.jdbc_v1_practice.modal.Book;
import com.jdbc_v1_practice.service.Service;

import java.util.List;

public class BookService implements Service<Book> {
    private BookDao bookDao;
    public BookService(){
       this.bookDao= new BookDao();
    }

    @Override
    public void save(Book book) {
        bookDao.SaveBook(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book,"book_id");
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book getById(int id) {
        Book book = new Book(id);
        return bookDao.selectById(book);
    }
}
