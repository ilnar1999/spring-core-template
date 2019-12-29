package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.configuration.ServiceConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class SimpleItemServiceTest {
    private SimpleItemService simpleItemService;
    private ArrayListItemRepository arrayListItemRepository;
    private LinkedListItemRepository linkedListItemRepository;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        ApplicationContext serviceContext = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        simpleItemService = serviceContext.getBean("simpleItemService", SimpleItemService.class);
        arrayListItemRepository = simpleItemService.getRepositoryContext().getBean("arrayListItemRepository",
                                                                                      ArrayListItemRepository.class);
        linkedListItemRepository = simpleItemService.getRepositoryContext().getBean("linkedListItemRepository",
                                                                                      LinkedListItemRepository.class);
        item1 = new Item(1, "Стол", 9990.0, "Brown");
        item2 = new Item(2, "Стул", 3990.0, "Black");
    }

    @Test
    public void getById() {
        if (simpleItemService.getRepositoryImplementation().equalsIgnoreCase("linked")) {
            linkedListItemRepository.createItem(item1);
            linkedListItemRepository.createItem(item2);
        } else {
            arrayListItemRepository.createItem(item1);
            arrayListItemRepository.createItem(item2);
        }
        assertEquals(item2, simpleItemService.getById(item2.getId()));
    }

    @Test
    public void createItem() {
        simpleItemService.createItem(item1);
        simpleItemService.createItem(item2);
        if (simpleItemService.getRepositoryImplementation().equalsIgnoreCase("linked")) {
            assertEquals(item2, linkedListItemRepository.getById(item2.getId()));
            assertNull(arrayListItemRepository.getById(item2.getId()));
        } else {
            assertEquals(item2, arrayListItemRepository.getById(item2.getId()));
            assertNull(linkedListItemRepository.getById(item2.getId()));
        }
    }
}