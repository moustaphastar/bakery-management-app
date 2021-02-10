package com.bakery.management.repository;

import com.bakery.management.domain.CashTransaction;
import com.bakery.management.enums.CashTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

/***
 * Provides a custom repository interface for {@link CashTransaction}.
 * @since 1.0
 * @author Moustapha Star
 */
@Repository
public interface CashTransactionRepository extends
        JpaRepository<CashTransaction, Integer> {
    // todo: Implement sorting by date ASC or DESC.

    /***
     * Fetches {@link CashTransaction} data from persistence.
     * Uses a finder query to filter results.
     * @param cashAccountId id of the cash account owning the transactions
     * @param fromDate beginning date of transactions
     * @param transactionType type of transactions
     * @param toDate ending date of transactions
     * @return an Optional container for CashTransaction entity list.
     */
    @Query("select t from CashTransaction as t "
            + "join CashAccount as c on c.id = t.cashAccount.id "
            + "where t.cashAccount.id = :cashAccountId "
            + "and t.transactionDate > :fromDate "
            + "and t.transactionDate < :toDate "
            + "and t.transactionType = :transactionType")
    Optional<List<CashTransaction>> getTransactions(
            @Param("cashAccountId") int cashAccountId,
            @Param("fromDate") OffsetDateTime fromDate,
            @Param("toDate") OffsetDateTime toDate,
            @Param("transactionType") CashTransactionType transactionType);
}
