package com.abn.design.LLD.lbms.search;

import com.abn.design.LLD.lbms.book.Book;

import java.util.Date;
import java.util.List;

public interface Search {

    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchBySubject(String subject);
    public List<Book> searchByPublishDate(Date publishDate);
}
