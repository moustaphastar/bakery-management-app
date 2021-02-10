package com.bakery.management.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * Provides constants with values for DocumentType enumeration.
 * @since 1.0
 * @author Moustapha Star
 */
public enum DocumentType {
    /**
     * Reserved for null.
     */
    DEFAULT("0"),
    /**
     * Not documented.
     */
    UNDOCUMENTED("1"),
    /**
     * Receipt.
     */
    BILL("2"),
    /**
     * Paper printed invoice.
     */
    INVOICE("3"),
    /**
     * Paper printed dispatch note.
     */
    DISPATCH_NOTE("4"),
    /**
     * Invoice, produced on e-document system.
     * Receiver and sender is registered to e-document system.
     */
    E_INVOICE("5"),
    /**
     * Dispatch note, produced on e-document system.
     * Receiver and sender is registered to e-document system.
     */
    E_DISPATCH_NOTE("6"),
    /**
     * A kind of e-Invoice whose receiver is not
     * registered to e-document system.
     */
    E_ARCHIVE("7"),
    /**
     * Self-employed receipt, produced on e-document system.
     */
    E_SMM("8"),
    /**
     * Producer receipt, produced on e-document system.
     */
    E_MM("9");
    // todo: Add other kinds.

    /***
     * The value of a constant defined in this enum type.
     */
    private final String value;

    /***
     * Holds the enum values as keys and enum constants as values.
     */
    private static final Map<String, DocumentType> MAP = new HashMap<>();

    /***
     * Constructor with String parameter.
     * @param enumValue enum value.
     */
    DocumentType(final String enumValue) {
        this.value = enumValue;
    }

    static {
        for (DocumentType enumType : DocumentType.values()) {
            MAP.put(enumType.value, enumType);
        }
    }

    /***
     * Returns the enum constant from enum value.
     * @param value enum value
     * @return DocumentType
     */
    public static DocumentType dbMappedValue(final String value) {
        return MAP.get(value);
    }

    /***
     * Returns the value of enum constant.
     * @return String
     */
    public String getValue() {
        return value;
    }
}
