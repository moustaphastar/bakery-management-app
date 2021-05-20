package com.bakery.management.repository;

import com.bakery.management.domain.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCategoryRepository
        extends JpaRepository<CustomerCategory, Integer> {
}
