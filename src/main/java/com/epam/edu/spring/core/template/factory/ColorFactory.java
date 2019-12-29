package com.epam.edu.spring.core.template.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColorFactory {
    @Value("${colors.value[0]}")
    private String color1;
    @Value("${colors.value[1]}")
    private String color2;
    @Value("${colors.value[2]}")
    private String color3;

    String getColor1() {
        return color1;
    }

    String getColor2() {
        return color2;
    }

    String getColor3() {
        return color3;
    }

    public List<String> getColorsList() {
        List<String> colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        return colors;
    }
}
