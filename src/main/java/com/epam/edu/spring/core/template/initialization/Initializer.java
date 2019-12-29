package com.epam.edu.spring.core.template.initialization;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    public void createItems(SimpleItemService simpleItemService) {
        simpleItemService.createItem(new Item(1, "����", 7490.0, "Yellow"));
        simpleItemService.createItem(new Item(2, "����", 2890.0, "Red"));
        simpleItemService.createItem(new Item(3, "����", 11990.0, "Black"));
        simpleItemService.createItem(new Item(4, "�����", 10390.0, "Red"));
        simpleItemService.createItem(new Item(5, "������", 4440.0, "Black"));
        simpleItemService.createItem(new Item(6, "����������", 450.0, "Yellow"));
    }
}
