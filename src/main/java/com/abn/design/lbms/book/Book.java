package com.abn.design.lbms.book;

import com.abn.design.lbms.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {

    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int noOfPages;
    private List<Author> authors;
}
