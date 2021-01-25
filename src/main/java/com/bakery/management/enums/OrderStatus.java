package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    DEFAULT("0"),
    PENDING("1"),
    APPROVED("2"),
    SHIPPED("3"),
    DELIVERED("4"),
    REJECTED("5"),
    REIMBURSED("6"),
    CANCELLED("7");

    private final String value;
    private static final Map<String, OrderStatus> map = new HashMap<>();

    OrderStatus(String value) {
        this.value = value;
    }

    static {
        for (OrderStatus enumType : OrderStatus.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static OrderStatus dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
