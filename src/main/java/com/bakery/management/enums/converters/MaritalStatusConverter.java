package com.bakery.management.enums.converters;

import com.bakery.management.enums.MaritalStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class MaritalStatusConverter
        implements AttributeConverter<MaritalStatus, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final MaritalStatus enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public MaritalStatus convertToEntityAttribute(final String dbColumnValue) {

        return MaritalStatus.dbMappedValue(dbColumnValue);
    }
}
