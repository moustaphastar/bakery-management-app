package com.bakery.management.repository;

import com.bakery.management.domain.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashAccountRepository extends JpaRepository<CashAccount, Integer> {
//    @Query("insert into CashAccount output inserted " +
//            "values ca")
//    CashAccount insert(CashAccount cashAccount);
}
