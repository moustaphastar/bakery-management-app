package com.bakery.management.enums.converters;

import com.bakery.management.enums.DocumentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, String> {

    @Override
    public String convertToDatabaseColumn(DocumentType enumType) {
        return enumType.getValue();
    }

    @Override
    public DocumentType convertToEntityAttribute(String dbData) {
        return DocumentType.dbMappedValue(dbData);
    }
}
