package com.bakery.management.enums.converters;

import com.bakery.management.enums.PaymentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentTypeConverter implements AttributeConverter<PaymentType, String> {

    @Override
    public String convertToDatabaseColumn(PaymentType enumType) {
        return enumType.getValue();
    }

    @Override
    public PaymentType convertToEntityAttribute(String dbData) {
        return PaymentType.dbMappedValue(dbData);
    }
}
