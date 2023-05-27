package com.example.demomaven.service.mapper;

import com.example.demomaven.entity.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class GenderAttributeConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return (gender != null)?  gender.getValue() : null;
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(Gender.values())
                .filter(each -> each.getValue() == dbData)
                .findFirst()
                .orElse(null);
    }
}
