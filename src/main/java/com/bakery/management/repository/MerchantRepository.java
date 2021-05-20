package com.bakery.management.repository;

import com.bakery.management.domain.Address;
import com.bakery.management.domain.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/***
 * Provides a custom repository interface for {@link Merchant}.
 * @since 1.0
 * @author Moustapha Star
 */
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {

    /***
     * Fetches {@link Merchant} data by id from persistence.
     * Uses a finder query.
     * @param id merchant id
     * @return an Optional container for Merchant entity.
     */
    @Query("select m from Merchant as m "
            + "join MerchantCategory as mc on mc.id = m.merchantCategory.id "
            + "where m.id = :id")
    Optional<Merchant> findById(@Param("id") UUID id);

    /***
     * Fetches {@link Address} data by id from persistence.
     * Uses a finder query including related {@see District},
     * {@see City} and {@see Country} data.
     * @param id address id
     * @return an Optional container for Address entity.
     */
    @Query(value = "select a.* from Address as a "
            + "join District as d on d.Id = a.DistrictId "
            + "join City as c on c.Id = d.CityId "
            + "join Country as o on o.Id = c.CountryId "
            + "where a.Id = :id", nativeQuery = true)
    Optional<Address> getAddressWithDetails(@Param("id") int id);
}
