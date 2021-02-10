package com.bakery.management.graphql.datafetchers;

import com.bakery.management.domain.Address;
import com.bakery.management.domain.City;
import com.bakery.management.repository.AddressRepository;
import com.bakery.management.repository.CityRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/***
 * Provides data fetching methods for graphql-java.
 */
// todo: Enhance Javadoc.
@Component
public class AddressDataFetcher {

    /***
     * Injection for AddressRepository object.
     */
    @Autowired
    private AddressRepository addressRepository;

    /***
     * Injection for CityRepository object.
     */
    @Autowired
    private CityRepository cityRepository;

    /***
     * Fetches the {@link Address} entity with given id from database.
     * Includes related entities if selection sets are provided within
     * graphql query.
     * @return Address
     */
    // todo: Enhance Javadoc.
    // todo: Implement all selection set rules to prevent PropertyDataFetcher.
    public DataFetcher<Address> fetchAddress() {
        return environment -> {
            int id = environment.getArgument("id");
            DataFetchingFieldSelectionSet selectionSet = environment
                    .getSelectionSet();

            if (selectionSet.contains("district/*")) {
                Optional<Address> address = addressRepository
                        .getAddressWithDetails(id);

                return address.orElse(null);
            } else {
                Optional<Address> address = addressRepository.findById(id);
                return address.orElse(null);
            }
        };
    }

    /***
     * Fetches {@link City} data by country id from database.
     * @return fetched City result as list or null
     */
    // todo: Enhance Javadoc.
    public DataFetcher<List<City>> fetchCityByCountry() {
        return environment -> {
            int countryId = environment.getArgument("countryId");
            Optional<List<City>> cities = cityRepository
                    .getWithCountry(countryId);
            return cities.orElse(null);
        };
    }

    /***
     * Fetches {@link Address} data by customer id from database.
     * @return fetched Address result or null
     */
    // todo: Enhance Javadoc.
    // todo: Result set is of type list?
    public DataFetcher<Address> getCustomerAddress() {
        return environment -> {
            String customerId = environment.getArgument("customerId");
            Optional<Address> address = addressRepository
                    .getCustomerAddress(customerId);
            return address.orElse(null);
        };
    }
}
