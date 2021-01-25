package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum AddressType {
    DEFAULT("0"),
    BILLING("1"),
    SHIPPING("2"),
    POSTAL("3"),
    LEGAL("4");

    private final String value;
    private static final Map<String, AddressType> map = new HashMap<>();

    AddressType(String value) {
        this.value = value;
    }

    static {
        for (AddressType enumType : AddressType.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static AddressType dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
