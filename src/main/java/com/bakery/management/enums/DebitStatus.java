package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum DebitStatus {
    DEFAULT("0"),
    PENDING("1"),
    OVERDUE("2"),
    FINALIZED("3"),
    CANCELLED("4");

    private final String value;
    private static final Map<String, DebitStatus> map = new HashMap<>();

    DebitStatus(String value) {
        this.value = value;
    }

    static {
        for (DebitStatus enumType : DebitStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static DebitStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
