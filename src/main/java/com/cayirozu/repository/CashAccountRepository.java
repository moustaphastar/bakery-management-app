package com.cayirozu.repository;

import com.cayirozu.db.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CashAccountRepository extends JpaRepository<CashAccount, Integer> {
}
