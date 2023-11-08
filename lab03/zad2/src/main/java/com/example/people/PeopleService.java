package com.example.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.domain.Person;

@Service
public class PeopleService {

    @Autowired
    @Qualifier("prezes")
    private Person prezes;

    @Autowired
    @Qualifier("wiceprezes")
    private Person wiceprezes;

    @Autowired
    @Qualifier("sekretarz")
    private Person sekretarz;

    @Autowired
    @Qualifier("osoba1")
    private Person osoba1;

    public void displayPeople() {
        System.out.println("Prezes: " + prezes);
        System.out.println("Wiceprezes: " + wiceprezes);
        System.out.println("Sekretarz: " + sekretarz);
        System.out.println("Osoba xml: " + osoba1);
    }
}
