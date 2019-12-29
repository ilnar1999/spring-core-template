package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.edu.spring.core.template.initialization")
public class InitializerConfiguration {
}
