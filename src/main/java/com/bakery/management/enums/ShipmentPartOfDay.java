package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

// TODO: Only shippable parts needed.
// TODO: Distinguish merchants from those don't use parts by merchant preferences.
public enum ShipmentPartOfDay {
    DEFAULT("0"),
    ANY("1"),
    DAWN("2"),
    MORNING("3"),
    NOON("4"),
    AFTERNOON("5"),
    EVENING("6"),
    NIGHT("7");

    private final String value;
    private static final Map<String, ShipmentPartOfDay> map = new HashMap<>();

    ShipmentPartOfDay(String value) {
        this.value = value;
    }

    static {
        for (ShipmentPartOfDay enumType : ShipmentPartOfDay.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static ShipmentPartOfDay dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
