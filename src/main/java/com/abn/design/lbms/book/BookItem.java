package com.abn.design.lbms.book;

import com.abn.design.lbms.Rack;
import com.abn.design.lbms.enums.BookStatus;

import java.util.Date;

public class BookItem extends Book {

    private String code;
    private boolean isReferenceBook;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

}
