package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for PaymentStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum PaymentStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Received but not yet approved by system.
     */
    PENDING("1"),
    /**
     * Controlled and accepted by authorized system user.
     */
    APPROVED("2"),
    /**
     * Received payment, pending or approved,
     * returned back to the payer.
     */
    REIMBURSED("3"),
    /**
     * Payment is cancelled.
     */
    CANCELLED("4");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, PaymentStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    PaymentStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (PaymentStatus enumType : PaymentStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return PaymentStatus
     */
    // todo: Change method name to fromDbColumnValue
    // todo: Is it ok use valueOf method instead of this?
    public static PaymentStatus dbMappedValue(final String value) {
        return MAP.get(value);
    }

    /***
     * Returns the value of enum constant.
     * @return String
     */
    public String getValue() {
        return value;
    }
}
