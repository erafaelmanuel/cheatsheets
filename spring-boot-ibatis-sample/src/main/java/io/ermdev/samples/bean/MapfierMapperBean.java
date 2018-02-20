package io.ermdev.samples.bean;

import io.ermdev.samples.typeconverter.PersonConverter;
import mapfierj.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapfierMapperBean {

    @Bean
    public Mapper mapper(PersonConverter personConverter) {
        Mapper mapper = new Mapper();
        mapper.getConverter().register(personConverter);
        return mapper;
    }
}
