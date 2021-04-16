package com.abn.design.lbms.accounts;

import com.abn.design.lbms.book.BookItem;

import java.util.Date;
import java.util.function.Predicate;

public class Member extends Account {

    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public int getTotalBooksCheckedout() {
        return 0;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return false;
    }


    private void incrementTotalBooksCheckedout() {

    }
}
