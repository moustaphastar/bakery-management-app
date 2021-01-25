package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentMethod;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipmentMethodConverter implements AttributeConverter<ShipmentMethod, String> {

    @Override
    public String convertToDatabaseColumn(ShipmentMethod enumType) {
        return enumType.getValue();
    }

    @Override
    public ShipmentMethod convertToEntityAttribute(String dbData) {
        return ShipmentMethod.dbMappedValue(dbData);
    }
}
