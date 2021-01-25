package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum CashTransactionType {
    DEFAULT("0"),
    RECEIVED("1"),
    PAID("2"),
    OUTSTANDING("3");

    private final String value;
    private static final Map<String, CashTransactionType> map = new HashMap<>();

    CashTransactionType(String value) {
        this.value = value;
    }

    static {
        for (CashTransactionType enumType : CashTransactionType.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static CashTransactionType dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}

