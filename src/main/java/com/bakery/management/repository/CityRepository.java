package com.bakery.management.repository;

import com.bakery.management.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/***
 * Provides a custom repository interface for {@link City}.
 * @since 1.0
 * @author Moustapha Star
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    /***
     * Fetches {@link City} data from persistence.
     * Uses a finder query to filter results.
     * @param countryId id of the country whose cities will be fetched
     * @return an Optional container for City entity list.
     */
    @Query("select c "
            + "from City as c "
            + "join Country as co on co.id = c.country.id "
            + "where c.country.id = :countryId")
    Optional<List<City>> getWithCountry(@Param("countryId") int countryId);
}
