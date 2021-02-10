package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

// todo: Only shippable parts needed.
// todo: Distinguish merchants from those don't use parts.

/***
 * Provides constants with values for ShipmentPartsOfDay enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum ShipmentPartsOfDay {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Shipment can be done any part of the day.
     */
    ANY("1"),
    /**
     * Shipment will be done at down.
     */
    DAWN("2"),
    /**
     * Shipment will be done at morning.
     */
    MORNING("3"),
    /**
     * Shipment will be done in noon.
     */
    NOON("4"),
    /**
     * Shipment will be done at afternoon.
     */
    AFTERNOON("5"),
    /**
     * Shipment will be done at evening.
     */
    EVENING("6"),
    /**
     * Shipment will be done at night.
     */
    NIGHT("7");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, ShipmentPartsOfDay> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    ShipmentPartsOfDay(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (ShipmentPartsOfDay enumType : ShipmentPartsOfDay.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return ShipmentPartsOfDay
     */
    public static ShipmentPartsOfDay dbMappedValue(final String value) {
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
