package com.bakery.management.graphql.datafetchers;

import com.bakery.management.domain.CashAccount;
import com.bakery.management.repository.CashAccountRepository;
import com.bakery.management.repository.CashTransactionRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CashAccountDataFetcher {
    @Autowired
    CashAccountRepository cashAccountRepository;
    @Autowired
    CashTransactionRepository cashTransactionRepository;

    public DataFetcher<CashAccount> fetchCashAccount() {
        return dataFetchingEnvironment -> {
            int id = dataFetchingEnvironment.getArgument("id");
            var cashAccount = cashAccountRepository.findById(id);
            return cashAccount.orElse(null);
        };
    }

    public DataFetcher<CashAccount> addCashAccount() {
        return new DataFetcher<CashAccount>() {
            @Override
            public CashAccount get(DataFetchingEnvironment environment) throws Exception {
                Map<String, Object> cashAccountInput = environment.getVariables();
                CashAccount cashAccount = new CashAccount();
                return cashAccountRepository.save(cashAccount);
            }
        };
    }
}
