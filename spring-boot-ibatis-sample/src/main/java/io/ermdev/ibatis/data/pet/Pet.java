package io.ermdev.ibatis.data.pet;

public class Pet {

    private Long id;
    private String name;
    private Integer size;
    private Long ownerId;

    public Pet() {}

    public Pet(String name, Integer size, Long ownerId) {
        this.name = name;
        this.size = size;
        this.ownerId = ownerId;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", ownerId=" + ownerId +
                '}';
    }
}
