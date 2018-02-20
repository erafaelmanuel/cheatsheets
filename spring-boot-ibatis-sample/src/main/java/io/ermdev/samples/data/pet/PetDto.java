package io.ermdev.samples.data.pet;

import io.ermdev.samples.data.person.Person;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PetDto {

    private Long id;
    private String name;
    private Integer size;
    private Person owner;

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
