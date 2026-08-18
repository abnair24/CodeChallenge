package com.abn.design.LLD.lbms.accounts;

import com.abn.design.LLD.lbms.Person;
import com.abn.design.LLD.lbms.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {

    private String id;
    private AccountStatus status;
    private Person person;
}
