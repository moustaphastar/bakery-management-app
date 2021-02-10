package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for ShipmentLoadStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum ShipmentLoadStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Not packed, not ready to be loaded.
     */
    PROCESSING("1"),
    /**
     * Packed and loaded into carrier.
     */
    LOADED("2"),
    /**
     * Delivered to target address.
     */
    COMPLETED("3"),
    /**
     * Unloaded from carrier.
     */
    UNLOADED("4"),
    /**
     * Load is cancelled.
     */
    CANCELLED("5");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, ShipmentLoadStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    ShipmentLoadStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (ShipmentLoadStatus enumType : ShipmentLoadStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return ShipmentLoadStatus
     */
    public static ShipmentLoadStatus dbMappedValue(final String value) {
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
