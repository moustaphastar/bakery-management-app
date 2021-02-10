package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for Gender enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum Gender {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Male gender.
     */
    MALE("1"),
    /**
     * Female gender.
     */
    FEMALE("2"),
    /**
     * Gender is not known or not specified.
     */
    UNKNOWN("3");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, Gender> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    Gender(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (Gender enumType : Gender.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return Gender
     */
    public static Gender dbMappedValue(final String value) {
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
