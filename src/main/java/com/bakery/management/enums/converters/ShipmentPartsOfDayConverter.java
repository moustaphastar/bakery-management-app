package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentPartsOfDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/***
 * Provides converter methods for enum type.
 * @since 1.0
 * @author Moustapha Star
 */
@Converter(autoApply = true)
public class ShipmentPartsOfDayConverter
        implements AttributeConverter<ShipmentPartsOfDay, String> {

    /***
     * Converts enum's constant to enum value before persisting to database.
     */
    @Override
    public String convertToDatabaseColumn(
            final ShipmentPartsOfDay enumConstant) {

        return enumConstant.getValue();
    }

    /***
     * Converts a string to enum's constant after fetching from database.
     */
    @Override
    public ShipmentPartsOfDay convertToEntityAttribute(
            final String dbColumnValue) {

        return ShipmentPartsOfDay.dbMappedValue(dbColumnValue);
    }
}
