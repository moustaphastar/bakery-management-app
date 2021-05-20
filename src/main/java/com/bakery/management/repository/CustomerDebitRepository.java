package com.bakery.management.repository;

import com.bakery.management.domain.CustomerDebit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDebitRepository
        extends JpaRepository<CustomerDebit, Integer> {
}
