package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for ShipmentMethod enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum ShipmentMethod {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Will be shipped via cargo.
     */
    CARGO("1"),
    /**
     * Will be shipped own delivery system.
     */
    DELIVERY("2"),
    /**
     * Will be picked by purchaser at the store.
     */
    PICKUP("3");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, ShipmentMethod> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    ShipmentMethod(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (ShipmentMethod enumType : ShipmentMethod.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return ShipmentMethod
     */
    public static ShipmentMethod dbMappedValue(final String value) {
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
