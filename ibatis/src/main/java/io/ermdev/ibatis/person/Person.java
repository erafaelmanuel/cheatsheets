package io.ermdev.ibatis.person;

import io.ermdev.ibatis.pet.Pet;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Long id;
    private String name;
    private List<Pet> pets =  new ArrayList<>();

    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
