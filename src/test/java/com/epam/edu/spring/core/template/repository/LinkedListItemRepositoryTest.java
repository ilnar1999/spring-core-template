package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class LinkedListItemRepositoryTest {
    private LinkedListItemRepository linkedListItemRepository;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        linkedListItemRepository = context.getBean("linkedListItemRepository", LinkedListItemRepository.class);
        item1 = new Item(1, "Стол", 9990.0, "Brown");
        item2 = new Item(2, "Стул", 3990.0, "Black");
    }

    @Test
    public void getByIdTest() {
        linkedListItemRepository.holder.add(item1);
        linkedListItemRepository.holder.add(item2);
        assertEquals(item2 ,linkedListItemRepository.getById(item2.getId()));
    }

    @Test
    public void getByNotExistingIdTest() {
        linkedListItemRepository.holder.add(item1);
        linkedListItemRepository.holder.add(item2);
        assertNull(linkedListItemRepository.getById(5));
    }

    @Test
    public void createItemTest() {
        linkedListItemRepository.createItem(item1);
        linkedListItemRepository.createItem(item2);
        assertEquals(item1, linkedListItemRepository.holder.get(0));
        assertEquals(item2, linkedListItemRepository.holder.get(1));
    }

    @Test
    public void createNullItemTest() {
        linkedListItemRepository.createItem(null);
        assertTrue(linkedListItemRepository.holder.isEmpty());
    }

    @Test
    public void createExistingItemTest() {
        int size;
        linkedListItemRepository.holder.add(item1);
        size = linkedListItemRepository.holder.size();
        linkedListItemRepository.createItem(item1);
        assertEquals(size, linkedListItemRepository.holder.size());
    }

    @Test
    public void setInitialSequenceTest() {
        int value = 15;
        linkedListItemRepository.setInitialSequence(value);
        assertEquals(value, linkedListItemRepository.initialSequence);
    }

    @Test
    public void getRandomValueTest() {
        int value = linkedListItemRepository.getRandomValue();
        assertTrue(value >= 1 && value <= 100);
    }
}