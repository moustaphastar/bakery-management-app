package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShipmentLoadStatus {
    DEFAULT("0"),
    PROCESSING("1"),
    LOADED("2"),
    COMPLETED("3"),
    UNLOADED("4"),
    CANCELLED("5");

    private final String value;
    private static final Map<String, ShipmentLoadStatus> map = new HashMap<>();

    ShipmentLoadStatus(String value) {
        this.value = value;
    }

    static {
        for (ShipmentLoadStatus enumType : ShipmentLoadStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static ShipmentLoadStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
