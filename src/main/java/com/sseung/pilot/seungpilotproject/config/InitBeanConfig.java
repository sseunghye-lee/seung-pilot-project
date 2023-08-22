package com.sseung.pilot.seungpilotproject.config;

import com.sseung.pilot.seungpilotproject.commons.utils.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitBeanConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mm = new ModelMapper();
        mm.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true);
        return mm;
    }

    @Bean
    public ModelMapperUtil modelMapperUtil() {
        return new ModelMapperUtil(modelMapper());
    }
}
