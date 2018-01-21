package io.ermdev.ibatis.repository;

import io.ermdev.ibatis.entity.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetRepository {

    @Insert("CREATE DATABASE IF NOT EXISTS dbsample_ibatis")
    void createDatabase();

    @Insert("DROP DATABASE IF EXISTS dbsample_ibatis")
    void dropDatabase();

    @Insert("USE dbsample_ibatis")
    void useDatabase();

    @Insert("CREATE TABLE IF NOT EXISTS tblpet(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), size INT, " +
            "PRIMARY KEY(id))")
    void createTable();

    @Select("SELECT * FROM tblpet WHERE id=#{petId}")
    Pet findById(@Param("petId") Long petId);

    @Select("SELECT * FROM tblpet")
    List<Pet> findAll();
}
