package com.icrown.gameapi.commons.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Roger
 */
@Component
public class JsonUtil {

    @Autowired
    private ObjectMapper mapper;

    /**
     * Serialize any Java value as a String.
     */
    public String generate(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * Deserialize JSON content from given JSON content String.
     */
    public <T> T parse(String content, Class<T> valueType) throws IOException {
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper.readValue(content, valueType);
    }

    /**
     * Serialize any Java value as a String.
     *
     * @param <T>
     */
    public <T> String generateFromList(List<T> list) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, list);

        final byte[] data = out.toByteArray();
        return new String(data);
    }

    /**
     * Deserialize JSON array as object.
     */
    public <T> List<T>  parseFromList(String content, Class<T> tClass) throws IOException{
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        return mapper.readValue(content, listType);
    }

    public boolean isValidJson(String json) {
        try {
            mapper.readTree(json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
