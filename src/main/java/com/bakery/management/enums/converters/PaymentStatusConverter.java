package com.bakery.management.enums.converters;

import com.bakery.management.enums.PaymentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class PaymentStatusConverter
        implements AttributeConverter<PaymentStatus, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final PaymentStatus enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public PaymentStatus convertToEntityAttribute(final String dbColumnValue) {

        return PaymentStatus.dbMappedValue(dbColumnValue);
    }
}
