package com.jdbc_v1_practice.modal;

import com.jdbc_v1_practice.annotation.Column;
import com.jdbc_v1_practice.annotation.Id;
import com.jdbc_v1_practice.annotation.Table;

@Table(name="books")
public class Book {
    @Id(name="book_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;
    @Column(name="desc")
    private String description;


    public Book(Integer id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +'\''+
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
