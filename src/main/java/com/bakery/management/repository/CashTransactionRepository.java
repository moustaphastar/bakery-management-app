package com.bakery.management.repository;

import com.bakery.management.model.entity.CashTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CashTransactionRepository extends JpaRepository<CashTransaction, Integer> {
    // TODO: Implement sorting by date ASC or DESC.
    Optional<List<CashTransaction>> findByCashAccountId(int id);
    @Query("select t from CashTransaction as t " +
            "join CashAccount as c on c.id = t.cashAccount.id " +
            "where t.cashAccount.id = :cashAccountId " +
            "and t.transactionDate > :fromDate " +
            "and t.transactionDate < :toDate " +
            "and t.transactionType = :transactionType")
    Optional<List<CashTransaction>> getTransactions(
            @Param("cashAccountId") int cashAccountId,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("transactionType") char transactionType);
}
