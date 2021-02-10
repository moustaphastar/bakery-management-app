package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for AddressType enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum AddressType {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Address to print on legal documents.
     */
    BILLING("1"),
    /**
     * Address to ship.
     */
    SHIPPING("2"),
    /**
     * Address to send documents physically.
     */
    POSTAL("3"),
    /**
     * Address recognized legally.
     */
    LEGAL("4");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, AddressType> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    AddressType(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (AddressType enumType : AddressType.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return AddressType
     */
    public static AddressType dbMappedValue(final String value) {
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
