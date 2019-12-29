package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.epam.edu.spring.core.template.factory")
@PropertySource("classpath:application.properties")
public class FactoryConfiguration {
}
