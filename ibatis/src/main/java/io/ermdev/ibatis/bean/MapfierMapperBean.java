package io.ermdev.ibatis.bean;

import io.ermdev.mapfierj.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapfierMapperBean {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper("io.ermdev.ibatis.typeconverter");
    }
}
