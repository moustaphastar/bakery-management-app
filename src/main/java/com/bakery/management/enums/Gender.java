package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    DEFAULT("0"),
    MALE("1"),
    FEMALE("2"),
    UNKNOWN("3");

    private final String value;
    private static final Map<String, Gender> map = new HashMap<>();

    Gender(String value) {
        this.value = value;
    }

    static {
        for (Gender enumType : Gender.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static Gender dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
