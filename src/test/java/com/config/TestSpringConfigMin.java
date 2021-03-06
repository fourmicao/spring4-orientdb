package com.config;

import com.hrb.config.SpringConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Import(AConfig.class)
@PropertySources({@PropertySource("classpath:app-test.properties")})
@Configuration
//@ComponentScan({"com.hrb.config"})
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value={SpringConfig.class}),
        basePackages = {
                "com.hrb.config"
        }
)
public class TestSpringConfigMin {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}