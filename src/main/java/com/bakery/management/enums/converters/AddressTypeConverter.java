package com.bakery.management.enums.converters;

import com.bakery.management.enums.AddressType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class AddressTypeConverter
        implements AttributeConverter<AddressType, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final AddressType enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public AddressType convertToEntityAttribute(final String dbColumnValue) {

        return AddressType.dbMappedValue(dbColumnValue);
    }
}
