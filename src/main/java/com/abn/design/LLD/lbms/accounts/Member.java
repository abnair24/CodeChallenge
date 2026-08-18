package com.abn.design.LLD.lbms.accounts;

import com.abn.design.LLD.lbms.book.BookItem;

import java.util.Date;

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
