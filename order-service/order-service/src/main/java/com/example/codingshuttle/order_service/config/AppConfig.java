package com.example.codingshuttle.order_service.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelmapper= new ModelMapper();

        modelmapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD) // strict means both name and type
                .setFieldMatchingEnabled(true) // match by field name directly
                .setSkipNullEnabled(true) // skip the null values
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return modelmapper;
    }

}
