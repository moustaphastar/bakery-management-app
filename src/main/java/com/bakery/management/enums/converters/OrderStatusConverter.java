package com.bakery.management.enums.converters;

import com.bakery.management.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return OrderStatus.dbMappedValue(dbData);
    }
}
