package com.abn.design.lbms.accounts;

import com.abn.design.lbms.Person;
import com.abn.design.lbms.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {

    private String id;
    private AccountStatus status;
    private Person person;
}
