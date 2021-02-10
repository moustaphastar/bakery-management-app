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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

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
    @Autowired
    private AddressRepository addressRepository;

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
     * Injection for MerchantRepository object.
     */
    @Autowired
    private MerchantRepository merchantRepository;

    /**
     * Fetches {@link CashTransaction} data from persistence.
     *
     * @return fetched CashTransaction result or null
     */
    public DataFetcher<CashTransaction> cashTransactionFetcher() {
        return environment -> {
            int id = environment.getArgument("id");
            var cashAccount = cashTransactionRepository.findById(id);
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
                // Validate dates and period than get an ordered map
                var dateMap = new DateHelpers(
                        LocalDate.parse(dateFrom), LocalDate.parse(dateTo))
                        .validatePeriod(3)
                        .buildMap();

                var transactions = cashTransactionRepository
                        .getTransactions(cashAccountId,
                                dateMap.getFromDate(),
                                dateMap.getToDate(),
                                transactionType);

                return transactions.orElse(null);
            } catch (DateTimeParseException | NullPointerException exception) {
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
                    .stream()
                    .findFirst()
                    .orElse(null);
        };
    }
}
