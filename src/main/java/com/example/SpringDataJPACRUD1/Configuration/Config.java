package com.example.SpringDataJPACRUD1.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.example.SpringDataJPACRUD1")
public class Config {
    @Bean
    @Scope(value = "prototype")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
