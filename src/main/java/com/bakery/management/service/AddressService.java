package com.bakery.management.service;

import com.bakery.management.domain.Address;

import java.util.Optional;

/***
 * Provides a custom repository interface for {@see Address}.
 *
 * @since 1.0
 * @author Moustapha Star
 */
public interface AddressService {

    /***
     * Fetch an address entity from persistence.
     * @param id Id of the entity to fetch
     * @return Address typed entity
     */
    Optional<Address> getAddress(int id);

}
