package com.bakery.management.service;

import com.bakery.management.dao.CustomerAddressHome;
import com.bakery.management.dao.EmployeeAddressHome;
import com.bakery.management.dao.MerchantAddressHome;
import com.bakery.management.domain.CustomerAddress;
import com.bakery.management.domain.Employee;
import com.bakery.management.domain.EmployeeAddress;
import com.bakery.management.domain.Merchant;
import com.bakery.management.domain.MerchantAddress;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Provides a business logic for {@link com.bakery.management.domain.Address}.
 * @since 1.0
 * @author Moustapha Star
 */
@Service
public class AddressService {

    /***
     * Static final field for logging utility.
     */
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /***
     * Injection for EmployeeAddressHome class.
     */
    @Autowired
    private EmployeeAddressHome employeeAddressHome;

    /***
     * Injection for CustomerAddressHome class.
     */
    @Autowired
    private CustomerAddressHome customerAddressHome;

    /***
     * Injection for MerchantAddressHome class.
     */
    @Autowired
    private MerchantAddressHome merchantAddressHome;

    /***
     * Class constructor.
     */
    public AddressService() {
        logger.setLevel(Level.ALL);
    }

    /***
     * Removes a {@link CustomerAddress} entity from persistence.
     * @param customerId String representation of a Customer Id
     * @return true if successful
     */
    public boolean removeCustomerAddress(final String customerId) {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setCustomerId(UUID.fromString(customerId));
        try {
            customerAddressHome.remove(customerAddress);
            return true;
        } catch (HibernateException exception) {
            logger.log(Level.WARNING, "Cannot remove entity", customerAddress);
            return false;
        }
    }

    /***
     * Removes an {@link EmployeeAddress} entity from persistence.
     * @param employeeId String representation of an Employee Id
     * @return true if successful
     */
    public boolean removeEmployeeAddress(final UUID employeeId) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setEmployee(employee);
        try {
            employeeAddressHome.remove(employeeAddress);
            return true;
        } catch (HibernateException exception) {
            logger.log(Level.WARNING, "Cannot remove entity", employeeAddress);
            return false;
        }
    }

    /***
     * Removes a {@link MerchantAddress} entity from persistence.
     * @param merchantId String representation of a Merchant Id
     * @return true if successful
     */
    public boolean removeMerchantAddress(final UUID merchantId) {
        Merchant merchant = new Merchant();
        merchant.setId(merchantId);
        MerchantAddress merchantAddress = new MerchantAddress();
        merchantAddress.setMerchant(merchant);
        try {
            merchantAddressHome.remove(merchantAddress);
            return true;
        } catch (HibernateException exception) {
            logger.log(Level.WARNING, "Cannot remove entity", merchantAddress);
            return false;
        }
    }
}
