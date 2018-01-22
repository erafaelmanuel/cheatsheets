package io.ermdev.ibatis.bean;

import io.ermdev.ibatis.typeconverter.PersonConverter;
import io.ermdev.mapfierj.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapfierMapperBean {

    @Autowired
    PersonConverter personConverter;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper =  new ModelMapper();
        mapper.getConverter().register(personConverter);
        return mapper;
    }
}
