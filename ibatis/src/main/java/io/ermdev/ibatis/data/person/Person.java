package io.ermdev.ibatis.data.person;

import io.ermdev.ibatis.data.pet.Pet;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Long id;
    private String name;
    private Boolean isGay;
    private List<Pet> pets =  new ArrayList<>();

    public Person() {
    }

    public Person(String name, Boolean isGay) {
        this.name = name;
        this.isGay = isGay;
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

    public Boolean getGay() {
        return isGay;
    }

    public void setGay(Boolean gay) {
        isGay = gay;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
