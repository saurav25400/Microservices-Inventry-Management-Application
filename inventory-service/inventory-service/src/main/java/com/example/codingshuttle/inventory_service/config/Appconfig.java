package com.example.codingshuttle.inventory_service.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public ModelMapper getmodelMapper(){
        ModelMapper modelMapper= new ModelMapper();

        // Set matching strategy too strict to avoid unintended mappings

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD) // matching based on both type and name
                .setFieldMatchingEnabled(true) //ensures that fields are matched directly
                .setSkipNullEnabled(true)

                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); // to access private field;

        return modelMapper;
    }


}
