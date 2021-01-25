package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

public enum DocumentType {
    DEFAULT("0"),
    UNDOCUMENTED("1"),
    BILL("2"),
    INVOICE("3"),
    INVOICE_NOTE("4"),
    E_INVOICE("5"),
    E_ARCHIVE("6");

    private final String value;
    private static final Map<String, DocumentType> map = new HashMap<>();

    DocumentType(String value) {
        this.value = value;
    }

    static {
        for (DocumentType enumType : DocumentType.values()) {
            map.put(enumType.value, enumType);
        }
    }

    public static DocumentType dbMappedValue(String value) {
        return map.get(value);
    }

    public String getValue() {
        return value;
    }
}
