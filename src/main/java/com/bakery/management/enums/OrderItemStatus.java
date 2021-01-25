package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderItemStatus {
    DEFAULT("0"),
    PENDING("1"),
    PREPARED("2"),
    LOADED("3"),
    SHIPPED("4"),
    DELIVERED("5"),
    REJECTED("6"),
    CANCELLED("7");

    private final String value;
    private static final Map<String, OrderItemStatus> map = new HashMap<>();

    OrderItemStatus(String value) {
        this.value = value;
    }

    static {
        for (OrderItemStatus enumType : OrderItemStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static OrderItemStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
