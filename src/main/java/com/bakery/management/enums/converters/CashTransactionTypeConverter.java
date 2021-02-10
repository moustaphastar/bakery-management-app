package com.bakery.management.enums.converters;

import com.bakery.management.enums.CashTransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class CashTransactionTypeConverter
        implements AttributeConverter<CashTransactionType, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(
            final CashTransactionType enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public CashTransactionType convertToEntityAttribute(
            final String dbColumnValue) {

        return CashTransactionType.dbMappedValue(dbColumnValue);
//        for (CashTransactionType cashTransactionType
//        : CashTransactionType.values()) {
//            if (cashTransactionType.getValue().equals(dbColumnValue)) {
//                return cashTransactionType;
//            }
//        }
//        return null;
    }
}
