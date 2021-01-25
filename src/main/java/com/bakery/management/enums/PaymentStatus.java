package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentStatus {
    DEFAULT("0"),
    PENDING("1"),
    APPROVED("2"),
    REIMBURSED("3"),
    CANCELLED("4");

    private final String value;
    private static final Map<String, PaymentStatus> map = new HashMap<>();

    PaymentStatus(String value) {
        this.value = value;
    }

    static {
        for (PaymentStatus enumType : PaymentStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static PaymentStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
