package com.bakery.management.enums.converters;

import com.bakery.management.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender enumType) {
        return enumType.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return Gender.dbMappedValue(dbData);
    }
}
