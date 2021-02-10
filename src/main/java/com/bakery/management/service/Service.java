package com.bakery.management.service;

import com.bakery.management.dao.AddressHome;
import com.bakery.management.dao.CountryHome;
import com.bakery.management.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * Provides a business logic for {@link com.bakery.management.domain.Address}.
 * @since 1.0
 * @author Moustapha Star
 */
public class Service {

    /***
     * Injection for AddressHome class.
     */
    @Autowired
    private AddressHome addressHome;

    /***
     * Injection for CountryHome class.
     */
    @Autowired
    private CountryHome countryHome;

    /***
     * Fetch address entity with the given id from database.
     * @param id Id of the address to fetch
     * @return Address
     */
    public Address getAddress(final int id) {
        return addressHome.findById(id);
    }

}
