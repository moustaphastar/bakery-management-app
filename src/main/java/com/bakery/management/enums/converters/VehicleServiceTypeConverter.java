package com.bakery.management.enums.converters;

import com.bakery.management.enums.VehicleServiceType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class VehicleServiceTypeConverter implements AttributeConverter<VehicleServiceType, String> {

    @Override
    public String convertToDatabaseColumn(VehicleServiceType enumType) {
        return enumType.getValue();
    }

    @Override
    public VehicleServiceType convertToEntityAttribute(String dbData) {
        return VehicleServiceType.dbMappedValue(dbData);
    }
}
