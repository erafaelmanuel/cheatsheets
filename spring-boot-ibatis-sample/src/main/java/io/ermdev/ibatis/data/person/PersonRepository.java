package io.ermdev.ibatis.data.person;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonRepository {

    @Insert("CREATE TABLE IF NOT EXISTS tblperson (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), " +
            "isGay TINYINT(1), PRIMARY KEY(id))")
    void createTable();

    @Select("SELECT * FROM tblperson WHERE id=#{personId}")
    Person findById(@Param("personId") Long personId);

    @Select("SELECT * FROM tblperson")
    Person[] findAll();
}
