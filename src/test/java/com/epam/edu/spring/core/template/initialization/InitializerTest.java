package com.epam.edu.spring.core.template.initialization;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class InitializerTest {
    private Initializer initializer;
    private SimpleItemService simpleItemService;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        initializer = context.getBean("initializer", Initializer.class);
        simpleItemService = context.getBean("simpleItemService", SimpleItemService.class);
    }

    @Test
    public void createItems() {
        initializer.createItems(simpleItemService);
        assertEquals("Светильник", simpleItemService.getById(6).getName());
    }
}