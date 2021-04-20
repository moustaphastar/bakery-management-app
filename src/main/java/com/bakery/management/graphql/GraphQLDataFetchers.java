package com.bakery.management.graphql;

import com.bakery.management.domain.Address;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

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
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Returns an Address class object
     *
     * @return Address or null
     */
    public DataFetcher<Address> AddressFetcher() {
        return dataFetchingEnvironment -> {
            int id = dataFetchingEnvironment.getArgument("id");
            var address = addressRepository.findById(id);
            return address.orElse(null);
        };
    }

    /**
     * Returns a CashTransaction class object
     *
     * @return CashTransaction or null
     */
    public DataFetcher<CashTransaction> CashTransactionFetcher() {
        return dataFetchingEnvironment -> {
            int id = dataFetchingEnvironment.getArgument("id");
            var cashAccount = cashTransactionRepository.findById(id);
            return cashAccount.orElse(null);
        };
    }

    /**
     * Returns a list of CashTransaction class object
     *
     * @return List<CashTransaction> or null
     */
    public DataFetcher<List<CashTransaction>> CashTransactionsFetcher() {
        return dataFetchingEnvironment -> {
            String cashAccountId = dataFetchingEnvironment.getArgument("accountId");
            String dateFrom = dataFetchingEnvironment.getArgument("dateFrom");
            String dateTo = dataFetchingEnvironment.getArgument("dateTo");
            String transactionTypeString = dataFetchingEnvironment.getArgument("transactionType");
            CashTransactionType transactionType = CashTransactionType.valueOf(transactionTypeString);

            // Validate dates and period than get an ordered map
            var dateMap = new DateHelpers(
                    LocalDate.parse(dateFrom), LocalDate.parse(dateTo))
                    .ValidatePeriod(3)
                    .GetMap();

            var transactions = cashTransactionRepository
                    .getTransactions(Integer.parseInt(cashAccountId),
                            dateFormat.parse(dateFrom),
                            dateFormat.parse(dateTo),
                            transactionType);

            return transactions.orElse(null);
        };
    }

    /**
     * Returns a Merchant class object
     *
     * @return Merchant or null
     */
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
