package com.bakery.management.repository;

import com.bakery.management.domain.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository
        extends JpaRepository<CustomerAddress, Integer> {
}
