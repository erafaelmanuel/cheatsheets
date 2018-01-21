package io.ermdev.ibatis.pet;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pet {

    private Long id;
    private String name;
    private Integer size;

    public Pet() {}

    public Pet(String name, Integer size) {
        this.name = name;
        this.size = size;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
