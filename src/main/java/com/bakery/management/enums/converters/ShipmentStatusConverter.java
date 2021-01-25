package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipmentStatusConverter implements AttributeConverter<ShipmentStatus, String> {

    @Override
    public String convertToDatabaseColumn(ShipmentStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public ShipmentStatus convertToEntityAttribute(String dbData) {
        return ShipmentStatus.dbMappedValue(dbData);
    }
}
