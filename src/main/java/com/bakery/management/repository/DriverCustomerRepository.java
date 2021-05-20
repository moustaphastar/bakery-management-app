package com.bakery.management.repository;

import com.bakery.management.domain.DriverCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCustomerRepository
        extends JpaRepository<DriverCustomer, Integer> {
}
