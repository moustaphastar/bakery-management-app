package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum MaritalStatus {
    DEFAULT("0"),
    MARRIED("1"),
    SINGLE("2"),
    WIDOWED("3");

    private final String value;
    private static final Map<String, MaritalStatus> map = new HashMap<>();

    MaritalStatus(String value) {
        this.value = value;
    }

    static {
        for (MaritalStatus enumType : MaritalStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static MaritalStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
