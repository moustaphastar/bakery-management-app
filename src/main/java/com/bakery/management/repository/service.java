package com.bakery.management.repository;

import com.bakery.management.model.dao.AddressHome;
import com.bakery.management.model.dao.CountryHome;
import com.bakery.management.model.entity.Address;
import com.bakery.management.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class service {
    @Autowired
    private AddressHome addressHome;
    @Autowired
    private CountryHome countryHome;

    public Address getAddress(int id){
        return addressHome.findById(id);
    }

//    public Set<Country> getCountries(){
//        //countryHome.
//    }
}
