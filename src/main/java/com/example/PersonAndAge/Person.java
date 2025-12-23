package com.example.PersonAndAge;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Person {

    // Fields
    private Integer id;
    private String name;
    private String address;

    // Constructors
    public Person(String name, String address, Integer id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}