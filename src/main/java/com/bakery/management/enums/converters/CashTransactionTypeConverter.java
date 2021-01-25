package com.bakery.management.enums.converters;

import com.bakery.management.enums.CashTransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CashTransactionTypeConverter implements AttributeConverter<CashTransactionType, String> {

    @Override
    public String convertToDatabaseColumn(CashTransactionType enumType) {
        return enumType.getValue();
    }

    @Override
    public CashTransactionType convertToEntityAttribute(String dbData) {
        return CashTransactionType.dbMappedValue(dbData);
//        for (CashTransactionType cashTransactionType : CashTransactionType.values()) {
//            if (cashTransactionType.getValue().equals(dbData)) {
//                return cashTransactionType;
//            }
//        }
//        return null;
    }
}
