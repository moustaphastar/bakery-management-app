package com.bakery.management.repository;

import com.bakery.management.db.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c " +
            "from City as c " +
            "join Country as co on co.id = c.country.id " +
            "where c.country.id = :countryId")
    Optional<Set<City>> getWithCountry(@Param("countryId") int countryId);
}
