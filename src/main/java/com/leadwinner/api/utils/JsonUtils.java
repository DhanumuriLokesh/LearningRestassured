package com.leadwinner.api.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	/*
	 * ObjectMapper Class
	 * JSON Node Class
	 * List/ArrayList*/
	public static Object[][] getData(String filePath) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = mapper.readTree(new File(filePath));

        List<Object[]> data = new ArrayList<>();

        for (JsonNode node : jsonArray) {              
            // dynamically reads ALL fields — no hardcoding
            List<Object> row = new ArrayList<>();

            node.fields().forEachRemaining(field -> {
                row.add(field.getValue().asText()); // reads any field name
            });

            data.add(row.toArray());
        }

        return data.toArray(new Object[0][]);
    }
//	
//	public static void main(String[] args) throws Exception {
//		Object[][] x = getData("src/test/resources/data/loginData.json");
//		for (Object[] row : x) {
//		    System.out.println("Username: " + row[0] + " | Password: " + row[1]);
//		}
//		
//	}

}
