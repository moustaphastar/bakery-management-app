package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum VehicleServiceType {
    DEFAULT("0"),
    ADMINISTRATIVE("1"),
    SHIPMENT("2"),
    PERSONAL("3"),
    SUPPORT("4"),
    OTHER("5");

    private final String value;
    private static final Map<String, VehicleServiceType> map = new HashMap<>();

    VehicleServiceType(String value) {
        this.value = value;
    }

    static {
        for (VehicleServiceType enumType : VehicleServiceType.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static VehicleServiceType dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
