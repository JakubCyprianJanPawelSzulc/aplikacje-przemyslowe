package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.service.CsvReader;
import com.example.domain.Person;

import java.util.Map;

@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);

        String filePath = "C:/Users/JSadr/Desktop/studia/semestr5/aplikacje_przemyslowe/lab03/demo/src/main/resources/plik.csv";
        Map<String, Person> personMap = CsvReader.readCsv(filePath);

        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
