package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for CashTransactionType enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
// todo: Correct side, add negative/positive and payable/receivable notes.
public enum CashTransactionType {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Transactions received. Credit. Goes into cash box.
     * Shown as positive at right hand side of cash book.
     */
    RECEIVED("1"),
    /**
     * Transactions made. Debit. Goes out of cash box.
     * Shown as negative at left hand side of cash book.
     */
    PAID("2"),
    /**
     * Opening balance for new cash accounts or balance
     * received from previous financial term for existing
     * cash accounts. Financial can either be a year or day.
     */
    OUTSTANDING("3");

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, CashTransactionType> MAP =
            new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    CashTransactionType(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (CashTransactionType enumType : CashTransactionType.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return CashTransactionType
     */
    public static CashTransactionType dbMappedValue(final String value) {
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

