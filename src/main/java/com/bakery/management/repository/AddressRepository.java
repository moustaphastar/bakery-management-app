package com.bakery.management.repository;

import com.bakery.management.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("select a from Address as a " +
            "join District as d on d.id = a.district.id " +
            "where a.id = :id")
    Optional<Address> findById(@Param("id") int id);

    @Query("select a from Address as a " +
            "join CustomerAddress as c " +
            "on c.address.id = a.id " +
            "where c.customer.id = :customerId")
    Optional<Address> getCustomerAddress(@Param("customerId") String customerId);
}
