package com.sseung.pilot.seungpilotproject.commons.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sseung.pilot.seungpilotproject.commons.dto.commons.FileDto;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;

public class FileConverter implements AttributeConverter<FileDto, String> {
    private static final ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

    @Override
    public String convertToDatabaseColumn(FileDto attribute) {
        if(attribute == null){
            return null;
        }

        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public FileDto convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }

        try {
            return mapper.readValue(dbData, new TypeReference<FileDto>(){});
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

}
