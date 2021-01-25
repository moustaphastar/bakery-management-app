package com.bakery.management.enums.converters;

import com.bakery.management.enums.OrderItemStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderItemStatusConverter implements AttributeConverter<OrderItemStatus, String> {

    @Override
    public String convertToDatabaseColumn(OrderItemStatus enumType) {
        return enumType.getValue();
    }

    @Override
    public OrderItemStatus convertToEntityAttribute(String dbData) {
        return OrderItemStatus.dbMappedValue(dbData);
    }
}
