package com.bakery.management.graphql;

import com.bakery.management.db.entity.Address;
import com.bakery.management.db.entity.CashAccount;
import com.bakery.management.db.entity.CashTransaction;
import com.bakery.management.db.entity.Merchant;
import com.bakery.management.repository.AddressRepository;
import com.bakery.management.repository.CashAccountRepository;
import com.bakery.management.repository.CashTransactionRepository;
import com.bakery.management.repository.MerchantRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class GraphQLDataFetchers {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CashAccountRepository cashAccountRepository;
    @Autowired
    CashTransactionRepository cashTransactionRepository;
    @Autowired
    MerchantRepository merchantRepository;

    public DataFetcher<Address> AddressFetcher() {
        return dataFetchingEnvironment -> {
            int id = dataFetchingEnvironment.getArgument("id");
            var address = addressRepository.findById(id);
            return address.orElse(null);
        };
    }

    public DataFetcher<CashAccount> CashAccountFetcher() {
        return dataFetchingEnvironment -> {
            int cashAccountId = dataFetchingEnvironment.getArgument("accountId");
            return cashAccountRepository
                    .findById(cashAccountId)
                    .stream()
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<CashTransaction> CashAccountTransactionFetcher() {
        return dataFetchingEnvironment -> {
            int cashAccountTransactionId = dataFetchingEnvironment.getArgument("id");
            return cashTransactionRepository
                    .findById(cashAccountTransactionId)
                    .stream()
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<List<CashTransaction>> CashAccountTransactionsFetcher() {
        return dataFetchingEnvironment -> {
            int cashAccountId = dataFetchingEnvironment.getArgument("accountId");
            var result = cashTransactionRepository
                    .findAll();
            var x = result.stream();
            var y = x.filter(t -> t.getCashAccount().getId() == cashAccountId);
            return y.collect(Collectors.toList());
        };
    }

    public DataFetcher<Merchant> MerchantFetcher() {
        return dataFetchingEnvironment -> {
            String merchantId = dataFetchingEnvironment.getArgument("id");
            return merchantRepository
                    .findById(merchantId)
                    .stream()
                    .findFirst()
                    .orElse(null);
        };
    }
}
