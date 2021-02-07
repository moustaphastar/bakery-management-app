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

@Component
public class AddressDataFetcher {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CityRepository cityRepository;

    // TODO: Implement all DataFetchingSelectionSet rules to prevent PropertyDataFetcher auto run.
    public DataFetcher<Address> fetchAddress() {
        return environment -> {
            int id = environment.getArgument("id");
            DataFetchingFieldSelectionSet selectionSet = environment.getSelectionSet();
            if (selectionSet.contains("district/*")) {
                var address = addressRepository.getAddressWithDetails(id);
                return address.orElse(null);
            } else {
                var address = addressRepository.findById(id);
                return address.orElse(null);
            }
        };
    }

    public DataFetcher<List<City>> fetchCityByCountry() {
        return environment -> {
            int countryId = environment.getArgument("countryId");
            var cities = cityRepository.getWithCountry(countryId);
            return cities.orElse(null);
        };
    }

    public DataFetcher<Address> getCustomerAddress() {
        return environment -> {
            String customerId = environment.getArgument("customerId");
            var address = addressRepository.getCustomerAddress(customerId);
            return address.orElse(null);
        };
    }
}
