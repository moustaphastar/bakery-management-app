package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShipmentStatus {
    DEFAULT("0"),
    LOADING("1"),
    SHIPPING("2"),
    COMPLETED("3"),
    CANCELLED("4");

    private final String value;
    private static final Map<String, ShipmentStatus> map = new HashMap<>();

    ShipmentStatus(String value) {
        this.value = value;
    }

    static {
        for (ShipmentStatus enumType : ShipmentStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static ShipmentStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
