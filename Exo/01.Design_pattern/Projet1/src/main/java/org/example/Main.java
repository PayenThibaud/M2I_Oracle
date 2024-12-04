package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

//        Map<String , String> dictionary = new HashMap<String , String>();
//
//        dictionary.put("db.host", "localhost");
//        dictionary.put("db.port", "3306");
//        dictionary.put("db.user", "root");
//
//        ConfigurationManager configurationManager = ConfigurationManager.getInstance(dictionary);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> dictionary = objectMapper.readValue(new File("src/main/resources/fichier.json"), Map.class);

        ConfigurationManager configurationManager = ConfigurationManager.getInstance(dictionary);



        Map<String , String> dictionary2 = new HashMap<String , String>();

        dictionary2.put("aaaaa", "aaaa");
        dictionary2.put(",,,,", ",,,,");
        dictionary2.put("r", "r");
        dictionary.remove("db.host");

        ConfigurationManager configurationManager2 = ConfigurationManager.getInstance(dictionary2);


        System.out.println(configurationManager2 == configurationManager);

        System.out.println(configurationManager.getValue("db.host"));

        System.out.println(configurationManager.getValue("db.port"));

        System.out.println(configurationManager.getValue("db.user"));

        System.out.println(configurationManager.getConfig());



        dictionary.put("aaaaa", "aaaa");
        dictionary.put(",,,,", ",,,,");
        dictionary.put("r", "r");


        System.out.println(configurationManager.getConfig());


    }
}