package com.bakery.management.enums.converters;

import com.bakery.management.enums.PaymentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class PaymentTypeConverter
        implements AttributeConverter<PaymentType, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final PaymentType enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public PaymentType convertToEntityAttribute(final String dbColumnValue) {

        return PaymentType.dbMappedValue(dbColumnValue);
    }
}
