package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for OrderItemStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum OrderItemStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Order item is not processed yet.
     */
    PENDING("1"),
    /**
     * Order item is produced, packed and ready to load.
     */
    PREPARED("2"),
    /**
     * Order item is loaded into carrier.
     */
    LOADED("3"),
    /**
     * Order item is posted to target address but not dropped yet.
     */
    SHIPPED("4"),
    /**
     * Order item is physically dropped to target address.
     */
    DELIVERED("5"),
    /**
     * Order item is rejected by target at drop point.
     */
    REJECTED("6"),
    /**
     * Order item is cancelled by target.
     */
    CANCELLED("7");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, OrderItemStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    OrderItemStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (OrderItemStatus enumType : OrderItemStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return OrderItemStatus
     */
    public static OrderItemStatus dbMappedValue(final String value) {
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
