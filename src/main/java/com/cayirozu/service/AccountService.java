package com.cayirozu.service;

import com.cayirozu.db.dao.CashAccountHome;
import com.cayirozu.db.entity.CashAccount;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final CashAccountHome home = new CashAccountHome() ;

    public AccountService() {
    }

    CashAccount accounts(int accountId) {
        return home.findById(accountId);
    }
}
