package com.bakery.management.graphql.datafetchers;

import com.bakery.management.db.entity.Address;
import com.bakery.management.db.entity.City;
import com.bakery.management.repository.AddressRepository;
import com.bakery.management.repository.CityRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDataFetcher {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CityRepository cityRepository;

    public DataFetcher<Address> fetchAddress() {
        return dataFetchingEnvironment -> {
            int id = dataFetchingEnvironment.getArgument("id");
            var address = addressRepository.findById(id);
            return address.orElse(null);
        };
    }

    public DataFetcher<List<City>> fetchCityByCountry() {
        return dataFetchingEnvironment -> {
            int countryId = dataFetchingEnvironment.getArgument("countryId");
            var cities = cityRepository.getWithCountry(countryId);
            return cities.orElse(null);
        };
    }
}
