package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum ShipmentMethod {
    DEFAULT("0"),
    CARGO("1"),
    DELIVERY("2"),
    PICKUP("3");

    private final String value;
    private static final Map<String, ShipmentMethod> map = new HashMap<>();

    ShipmentMethod(String value) {
        this.value = value;
    }

    static {
        for (ShipmentMethod enumType : ShipmentMethod.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static ShipmentMethod dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
