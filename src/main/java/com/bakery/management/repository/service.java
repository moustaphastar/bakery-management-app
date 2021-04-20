package com.bakery.management.repository;

import com.bakery.management.dao.AddressHome;
import com.bakery.management.dao.CountryHome;
import com.bakery.management.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;

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
