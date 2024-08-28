package com.ericsson.cifwk.metricsepe;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JsonParser {

    private ObjectMapper mapper;
    private static JsonParser jsonParser;
    private static final Logger log = Logger.getLogger(JsonParser.class.getName());

    public static JsonParser getInstance() {
        if (jsonParser == null)
            jsonParser = new JsonParser();

        return jsonParser;
    }

    private JsonParser() {

        mapper = new ObjectMapper();

    }


    public Object parseJsonStringToObject(String jsonString, Class<?> classtype) {
        Object object = null;
        try {
            object = mapper.readValue(jsonString, classtype);
        } catch (JsonParseException e) {
            log.log(Level.SEVERE, e.getMessage());
        } catch (JsonMappingException e) {
            log.log(Level.SEVERE, e.getMessage());

        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());

        }
        return object;
    }

}