package com.example.service;

import com.example.domain.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CsvReader {

    public static Map<String, Person> readCsv(String filePath) {
        Map<String, Person> personMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 5) {
                    String id = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String email = data[3];
                    int birthYear = Integer.parseInt(data[4]);

                    UUID uuid = UUID.fromString(id);
                    
                    Person person = new Person(uuid, firstName, lastName, email, birthYear);
                    
                    personMap.put(id, person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return personMap;
    }
}