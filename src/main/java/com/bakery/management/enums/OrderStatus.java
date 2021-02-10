package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for OrderStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum OrderStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Persisted but not yet approved by system.
     */
    PENDING("1"),
    /**
     * Controlled and accepted by authorized user.
     */
    APPROVED("2"),
    /**
     * Shipped to target address but not dropped yet.
     */
    SHIPPED("3"),
    /**
     * Dropped to target address.
     */
    DELIVERED("4"),
    /**
     * Rejected by target at delivery.
     */
    REJECTED("5"),
    /**
     * Payments received for cancelled or rejected orders
     * returned to the payer.
     */
    REIMBURSED("6"),
    /**
     * Order is cancelled.
     */
    CANCELLED("7");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, OrderStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    OrderStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (OrderStatus enumType : OrderStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return OrderStatus
     */
    public static OrderStatus dbMappedValue(final String value) {
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
