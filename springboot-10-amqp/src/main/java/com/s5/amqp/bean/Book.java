package com.s5.amqp.bean;

/**
 * @Author: Aresong
 * @Date: 2019/7/3 0:59
 * @Version 1.0
 */
public class Book {
    private String bookname;
    private String author;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
