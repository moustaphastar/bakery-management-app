package com.bakery.management.repository;

import com.bakery.management.domain.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Provides a custom repository interface for {@link CashAccount}.
 * @since 1.0
 * @author Moustapha Star
 */
// todo: Implement the interface.
@Repository
public interface CashAccountRepository
        extends JpaRepository<CashAccount, Integer> {
//    @Query("insert into CashAccount output inserted " +
//            "values ca")
//    CashAccount insert(CashAccount cashAccount);
}
