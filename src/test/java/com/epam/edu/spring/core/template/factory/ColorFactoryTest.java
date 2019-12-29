package com.epam.edu.spring.core.template.factory;

import com.epam.edu.spring.core.template.configuration.FactoryConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ColorFactoryTest {
    private ColorFactory colorFactory;
    private String color1;
    private String color2;
    private String color3;

    @Before
    public void setUp() {
        ApplicationContext factoryContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        colorFactory = factoryContext.getBean("colorFactory", ColorFactory.class);
        color1 = colorFactory.getColor1();
        color2 = colorFactory.getColor2();
        color3 = colorFactory.getColor3();
    }

    @Test
    public void getColorsList() {
        List<String> colors = colorFactory.getColorsList();
        assertEquals(color1, colorFactory.getColorsList().get(0));
        assertEquals(color2, colorFactory.getColorsList().get(1));
        assertEquals(color3, colorFactory.getColorsList().get(2));
    }
}