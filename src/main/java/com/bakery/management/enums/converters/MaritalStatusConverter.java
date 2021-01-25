package com.bakery.management.enums.converters;

import com.bakery.management.enums.MaritalStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MaritalStatusConverter implements AttributeConverter<MaritalStatus, String> {

    @Override
    public String convertToDatabaseColumn(MaritalStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public MaritalStatus convertToEntityAttribute(String dbData) {
        return MaritalStatus.dbMappedValue(dbData);
    }
}
