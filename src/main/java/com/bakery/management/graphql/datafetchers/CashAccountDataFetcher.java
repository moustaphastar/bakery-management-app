package com.bakery.management.graphql.datafetchers;

import com.bakery.management.domain.CashAccount;
import com.bakery.management.repository.CashAccountRepository;
import com.bakery.management.repository.CashTransactionRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/***
 * Provides data fetching methods for graphql-java.
 * @since 1.0
 * @author Moustapha Star
 */
// todo: Enhance Javadoc.
@Component
public class CashAccountDataFetcher {

    /***
     * Injection for CashAccountRepository object.
     */
    @Autowired
    private CashAccountRepository cashAccountRepository;

    /***
     * Injection for CashTransactionRepository object.
     */
    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    /***
     * Fetches {@link CashAccount} data from persistence.
     * @return fetched CashAccount result or null
     */
    // todo: Enhance Javadoc.
    public DataFetcher<CashAccount> fetchCashAccount() {
        return environment -> {
            int id = environment.getArgument("id");
            Optional<CashAccount> cashAccount = cashAccountRepository
                    .findById(id);
            return cashAccount.orElse(null);
        };
    }

    /***
     * Persists {@link CashAccount} data to database.
     * @return persisted Address result or null
     */
    // todo: Enhance Javadoc.
    public DataFetcher<CashAccount> addCashAccount() {
        return environment -> {
            Map<String, Object> cashAccountInput = environment.getVariables();
            CashAccount cashAccount = new CashAccount();
            return cashAccountRepository.save(cashAccount);
        };
    }
}
