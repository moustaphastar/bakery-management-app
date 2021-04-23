package com.bakery.management.graphql;

import com.bakery.management.domain.CashTransaction;
import com.bakery.management.domain.Merchant;
import com.bakery.management.enums.CashTransactionType;
import com.bakery.management.helpers.DateHelpers;
import com.bakery.management.repository.AddressRepository;
import com.bakery.management.repository.CashAccountRepository;
import com.bakery.management.repository.CashTransactionRepository;
import com.bakery.management.repository.MerchantRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

/***
 * Provides data fetchers for graphql-java.
 * @since 1.0
 * @author Moustapha Star
 */
@Component
@Transactional
public class GraphQLDataFetchers {

    /***
     * Injection for AddressRepository object.
     */
    private final AddressRepository addressRepository;

    /***
     * Injection for CashAccountRepository object.
     */
    private final CashAccountRepository cashAccountRepository;

    /***
     * Injection for CashTransactionRepository object.
     */
    private final CashTransactionRepository cashTransactionRepository;

    /***
     * Injection for MerchantRepository object.
     */
    private final MerchantRepository merchantRepository;

    /**
     * Class constructor
     */
    public GraphQLDataFetchers(final AddressRepository addressRepo,
                               final CashAccountRepository cashAccountRepo,
                               final CashTransactionRepository transactionRepo,
                               final MerchantRepository merchantRepo){
        this.addressRepository = addressRepo;
        this.cashAccountRepository = cashAccountRepo;
        this.cashTransactionRepository = transactionRepo;
        this.merchantRepository = merchantRepo;
    }

    /**
     * Fetches {@link CashTransaction} data from persistence.
     *
     * @return fetched CashTransaction result or null
     */
    public DataFetcher<CashTransaction> cashTransactionFetcher() {
        return environment -> {
            int id = environment.getArgument("id");
            Optional<CashTransaction> cashAccount = cashTransactionRepository
                    .findById(id);
            return cashAccount.orElse(null);
        };
    }

    /**
     * Fetches {@link CashTransaction} data from persistence.
     *
     * @return fetched CashTransaction result as list or null
     */
    public DataFetcher<List<CashTransaction>> cashTransactionsFetcher() {
        return environment -> {
            int cashAccountId = environment.getArgument("accountId");
            String dateFrom = environment.getArgument("dateFrom");
            String dateTo = environment.getArgument("dateTo");
            String transactionTypeString = environment
                    .getArgument("transactionType");
            CashTransactionType transactionType = CashTransactionType
                    .valueOf(transactionTypeString);

            try {
                DateHelpers dateMap = new DateHelpers(dateFrom, dateTo);

                Optional<List<CashTransaction>> transactions =
                        cashTransactionRepository
                                .getTransactions(cashAccountId,
                                        dateMap.getEarlierDate(),
                                        dateMap.getLaterDate(),
                                        transactionType);

                return transactions.orElse(null);
            } catch (DateTimeParseException | NullPointerException
                    | IllegalArgumentException exception) {
                return null;
            }
        };
    }

    /**
     * Fetches {@link CashTransaction} data from persistence.
     *
     * @return fetched CashTransaction result or null
     */
    public DataFetcher<Merchant> merchantFetcher() {
        return environment -> {
            String merchantId = environment.getArgument("id");
            return merchantRepository
                    .findById(merchantId)
                    .orElse(null);
        };
    }
}
