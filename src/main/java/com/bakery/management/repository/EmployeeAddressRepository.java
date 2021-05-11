package com.bakery.management.repository;

import com.bakery.management.domain.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAddressRepository
        extends JpaRepository<EmployeeAddress, Integer> {
}
