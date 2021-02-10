package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class ShipmentStatusConverter
        implements AttributeConverter<ShipmentStatus, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final ShipmentStatus enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public ShipmentStatus convertToEntityAttribute(final String dbColumnValue) {

        return ShipmentStatus.dbMappedValue(dbColumnValue);
    }
}
