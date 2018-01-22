package io.ermdev.ibatis.person;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonRepository {

    @Insert("CREATE TABLE IF NOT EXISTS tblperson (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), PRIMARY KEY(id))")
    void createTable();

    @Select("SELECT * FROM tblperson WHERE id=#{personId}")
    Person findById(@Param("personId") Long personId);
}
