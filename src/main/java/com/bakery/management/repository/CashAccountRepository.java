package com.bakery.management.repository;

import com.bakery.management.db.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashAccountRepository extends JpaRepository<CashAccount, Integer> {
}
