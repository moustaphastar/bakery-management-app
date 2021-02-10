package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for VehicleServiceType enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum VehicleServiceType {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Administrative usage.
     */
    ADMINISTRATIVE("1"),
    /**
     * Shipment usage.
     */
    SHIPMENT("2"),
    /**
     * Personal usage.
     */
    PERSONAL("3"),
    /**
     * Support service usage.
     */
    SUPPORT("4"),
    /**
     * Other usage.
     */
    OTHER("5");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, VehicleServiceType> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    VehicleServiceType(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (VehicleServiceType enumType : VehicleServiceType.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return VehicleServiceType
     */
    public static VehicleServiceType dbMappedValue(final String value) {
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
