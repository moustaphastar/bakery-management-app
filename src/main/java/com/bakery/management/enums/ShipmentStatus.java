package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for ShipmentStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum ShipmentStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Carrier is being loaded.
     */
    LOADING("1"),
    /**
     * Carrier is loaded and started trip.
     */
    SHIPPING("2"),
    /**
     * Carrier completed trip and returned.
     */
    COMPLETED("3"),
    /**
     * Shipment is cancelled.
     */
    CANCELLED("4");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, ShipmentStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    ShipmentStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (ShipmentStatus enumType : ShipmentStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return ShipmentStatus
     */
    public static ShipmentStatus dbMappedValue(final String value) {
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
