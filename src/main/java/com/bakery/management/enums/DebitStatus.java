package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for DebitStatus enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum DebitStatus {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Not finalized and not overdue.
     */
    PENDING("1"),
    /**
     * Not finalized and is overdue.
     */
    OVERDUE("2"),
    /**
     * Paid by debtor.
     */
    FINALIZED("3"),
    /**
     * Debit is cancelled.
     */
    CANCELLED("4");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, DebitStatus> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    DebitStatus(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (DebitStatus enumType : DebitStatus.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return DebitStatus
     */
    public static DebitStatus dbMappedValue(final String value) {
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
