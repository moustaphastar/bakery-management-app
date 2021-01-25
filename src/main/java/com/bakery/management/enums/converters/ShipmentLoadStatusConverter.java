package com.bakery.management.enums.converters;

import com.bakery.management.enums.ShipmentLoadStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipmentLoadStatusConverter implements AttributeConverter<ShipmentLoadStatus, String> {

    @Override
    public String convertToDatabaseColumn(ShipmentLoadStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public ShipmentLoadStatus convertToEntityAttribute(String dbData) {
        return ShipmentLoadStatus.dbMappedValue(dbData);
    }
}
