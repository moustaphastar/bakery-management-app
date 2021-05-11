package com.bakery.management.repository;

import com.bakery.management.domain.CustomerDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDiscountRepository
        extends JpaRepository<CustomerDiscount, Integer> {
}
