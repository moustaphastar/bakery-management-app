package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for PaymentType enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum PaymentType {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Paid as cash.
     */
    CASH("1"),
    /**
     * Credited to bank account.
     */
    BANK("2"),
    /**
     * Paid by cheque.
     */
    CHEQUE("3"),
    /**
     * Legal paper that can be transferred to money.
     */
    PAPER("4"),
    /**
     * Other legal tools that can be transferred to money.
     */
    OTHER("5");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, PaymentType> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    PaymentType(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (PaymentType enumType : PaymentType.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return PaymentType
     */
    public static PaymentType dbMappedValue(final String value) {
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
