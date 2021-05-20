package com.bakery.management.repository;

import com.bakery.management.domain.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Provides a custom repository interface for {@link CustomerAddress}.
 * @since 1.0
 * @author Moustapha Star
 */
// todo: Define the aggregate root and update the javadoc accordingly.
@Repository
public interface CustomerAddressRepository
        extends JpaRepository<CustomerAddress, Integer> {
}
