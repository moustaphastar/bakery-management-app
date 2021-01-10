package com.bakery.management.repository;

import com.bakery.management.db.entity.CashTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashTransactionRepository extends JpaRepository<CashTransaction, Integer> {
}
