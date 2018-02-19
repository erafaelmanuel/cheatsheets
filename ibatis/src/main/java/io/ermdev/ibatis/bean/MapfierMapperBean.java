package io.ermdev.ibatis.bean;

import io.ermdev.ibatis.typeconverter.PersonConverter;
import mapfierj.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapfierMapperBean {

    @Bean
    public Mapper createMapper(PersonConverter personConverter) {
        Mapper mapper = new Mapper();
        mapper.getConverter().register(personConverter);
        return mapper;
    }
}
