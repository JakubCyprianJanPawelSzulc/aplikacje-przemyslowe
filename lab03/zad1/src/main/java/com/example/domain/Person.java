package com.example.domain;

import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int birthYear;

    public Person() {
        this.id = UUID.randomUUID();
    }

    public Person(String name, String surname, String email, int birthYear) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthYear = birthYear;
    }

    public Person(UUID id, String name, String surname, String email, int birthYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthYear = birthYear;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id.toString() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

}
