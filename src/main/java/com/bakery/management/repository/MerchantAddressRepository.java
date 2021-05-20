package com.bakery.management.repository;

import com.bakery.management.domain.Address;
import com.bakery.management.domain.MerchantAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 * Provides a custom repository interface for {@link Address}.
 * @since 1.0
 * @author Moustapha Star
 */
@Repository
public interface MerchantAddressRepository
        extends JpaRepository<MerchantAddress, Integer> {

    /***
     * Fetches {@link Address} data by id from persistence.
     * Uses a finder query.
     * @param id address id
     * @return an Optional container for Address entity.
     */
    @Query("select a from Address as a "
            + "join District as d on d.id = a.district.id "
            + "where a.id = :id")
    Optional<Address> findById(@Param("id") int id);

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

    /***
     * Fetches {@link Address} data by id from persistence.
     * Uses a finder query including related {@see Customer} data.
     * @param customerId {@link com.bakery.management.domain.Customer} id
     * @return an Optional container for Address entity.
     */
    @Query("select a from Address as a "
            + "join CustomerAddress as c "
            + "on c.address.id = a.id "
            + "where c.customer.id = :customerId")
    Optional<Address> getCustomerAddress(
            @Param("customerId") String customerId);
}
