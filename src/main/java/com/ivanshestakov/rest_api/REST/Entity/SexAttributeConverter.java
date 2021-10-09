package com.ivanshestakov.rest_api.REST.Entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SexAttributeConverter implements AttributeConverter<Sex, Character> {
    @Override
    public Character convertToDatabaseColumn(Sex sex) {
        if (sex == Sex.MALE) {
            return 'm';
        }
        if (sex == Sex.FEMALE) {
            return 'f';
        }
        return null;
    }

    @Override
    public Sex convertToEntityAttribute(Character character) {
        if (character == 'm') {
            return Sex.MALE;
        }
        if (character == 'f') {
            return Sex.FEMALE;
        }
        return null;
    }
}
