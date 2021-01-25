package com.bakery.management.enums.converters;

import com.bakery.management.enums.DebitStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DebitStatusConverter implements AttributeConverter<DebitStatus, String> {

    @Override
    public String convertToDatabaseColumn(DebitStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public DebitStatus convertToEntityAttribute(String dbData) {
        return DebitStatus.dbMappedValue(dbData);
    }
}
