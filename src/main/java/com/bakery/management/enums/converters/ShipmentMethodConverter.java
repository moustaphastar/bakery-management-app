package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentMethod;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class ShipmentMethodConverter
        implements AttributeConverter<ShipmentMethod, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(final ShipmentMethod enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public ShipmentMethod convertToEntityAttribute(final String dbColumnValue) {

        return ShipmentMethod.dbMappedValue(dbColumnValue);
    }
}
