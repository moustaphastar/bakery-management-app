package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentPartsOfDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipmentPartsOfDayConverter implements AttributeConverter<ShipmentPartsOfDay, String> {

    @Override
    public String convertToDatabaseColumn(ShipmentPartsOfDay enumType) {
        return enumType.getValue();
    }

    @Override
    public ShipmentPartsOfDay convertToEntityAttribute(String dbData) {
        return ShipmentPartsOfDay.dbMappedValue(dbData);
    }
}
