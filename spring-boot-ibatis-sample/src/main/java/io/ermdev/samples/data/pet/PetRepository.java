package io.ermdev.samples.data.pet;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetRepository {
    @Insert("CREATE TABLE IF NOT EXISTS tblpet(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), size INT, " +
            "ownerId BIGINT, PRIMARY KEY(id), FOREIGN KEY(ownerId) REFERENCES tblperson(id) ON UPDATE CASCADE " +
            "ON DELETE CASCADE)")
    void createTable();

    @Select("SELECT * FROM tblpet WHERE id=#{petId}")
    Pet findById(@Param("petId") Long petId);

    @Select("SELECT * FROM tblpet")
    List<Pet> findAll();

    @Insert("INSERT INTO tblpet(name, size) VALUES(#{name}, #{size})")
    void add(Pet pet);
}
