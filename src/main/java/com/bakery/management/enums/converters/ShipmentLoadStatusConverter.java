package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentLoadStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class ShipmentLoadStatusConverter
        implements AttributeConverter<ShipmentLoadStatus, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(
            final ShipmentLoadStatus enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public ShipmentLoadStatus convertToEntityAttribute(
            final String dbColumnValue) {

        return ShipmentLoadStatus.dbMappedValue(dbColumnValue);
    }
}
