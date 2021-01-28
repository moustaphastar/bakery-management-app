package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentPartOfDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipmentPartsOfDayConverter implements AttributeConverter<ShipmentPartOfDay, String> {

    @Override
    public String convertToDatabaseColumn(ShipmentPartOfDay enumType) {
        return enumType.getValue();
    }

    @Override
    public ShipmentPartOfDay convertToEntityAttribute(String dbData) {
        return ShipmentPartOfDay.dbMappedValue(dbData);
    }
}
