package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for MaritalStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum MaritalStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Married.
     */
    MARRIED("1"),
    /**
     * Single.
     */
    SINGLE("2"),
    /**
     * Divorced.
     */
    DIVORCED("3");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, MaritalStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    MaritalStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (MaritalStatus enumType : MaritalStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return MaritalStatus
     */
    public static MaritalStatus dbMappedValue(final String value) {
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
