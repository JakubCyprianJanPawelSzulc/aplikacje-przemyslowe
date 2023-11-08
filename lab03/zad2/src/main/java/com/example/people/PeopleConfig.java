package com.example.people;

import com.example.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:people-config.xml")
public class PeopleConfig {

    @Bean(name = "prezes")
    public Person prezes() {
        return new Person("Jacek", "Kowalski", "jacek@example.com", 1980);
    }

    @Bean(name = "wiceprezes")
    public Person wiceprezes() {
        return new Person("Jan", "Nowak", "jan@example.com", 1970);
    }

    @Bean(name = "sekretarz")
    public Person sekretarz() {
        return new Person("Anna", "Kowalska", "anna@example.com", 1985);
    }
}
