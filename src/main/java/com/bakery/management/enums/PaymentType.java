package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentType {
    DEFAULT("0"),
    CASH("1"),
    BANK("2"),
    CHEQUE("3"),
    PAPER("4"),
    OTHER("5");

    private final String value;
    private static final Map<String, PaymentType> map = new HashMap<>();

    PaymentType(String value) {
        this.value = value;
    }

    static {
        for (PaymentType enumType : PaymentType.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static PaymentType dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
