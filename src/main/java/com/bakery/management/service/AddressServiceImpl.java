package com.bakery.management.service;

import com.bakery.management.domain.Address;
import com.bakery.management.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Provides a business logic for {@link com.bakery.management.domain.Address}.
 * @since 1.0
 * @author Moustapha Star
 */
@Service
public class AddressServiceImpl implements AddressService {

    /***
     * Static final field for logging utility.
     */
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /***
     * Injection for EmployeeAddressHome class.
     */
    private final AddressRepository addressRepository;

    /***
     * Class constructor.
     * @param addressRepository Address repository object.
     */
    public AddressServiceImpl(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        logger.setLevel(Level.ALL);
    }

    /***
     * Finds the Address entity from persistence.
     * @param id Integer representation of an address id
     * @return Address type representation or null
     */
    public Optional<Address> getAddress(final int id) {
        logger.log(Level.INFO, "Fetching entity from db.", id);
        return addressRepository.findById(id);
    }
}
