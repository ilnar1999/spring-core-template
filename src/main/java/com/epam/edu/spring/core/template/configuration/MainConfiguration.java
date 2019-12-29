package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({FactoryConfiguration.class, InitializerConfiguration.class, RepositoryConfiguration.class,
         ServiceConfiguration.class, BppConfiguration.class})
public class MainConfiguration {
}
