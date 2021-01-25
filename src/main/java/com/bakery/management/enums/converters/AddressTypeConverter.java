package com.bakery.management.enums.converters;

import com.bakery.management.enums.AddressType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType, String> {

    @Override
    public String convertToDatabaseColumn(AddressType enumType) {
        return enumType.getValue();
    }

    @Override
    public AddressType convertToEntityAttribute(String dbData) {
        return AddressType.dbMappedValue(dbData);
    }
}
