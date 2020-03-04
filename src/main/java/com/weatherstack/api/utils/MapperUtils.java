package com.weatherstack.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherstack.api.dto.Location;

import static com.weatherstack.api.utils.FileUtils.getJsonData;

public class MapperUtils {

    public static <T> T mapToObject(String s, Class<T> cls){
        try {
            return new ObjectMapper().readValue(s, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
