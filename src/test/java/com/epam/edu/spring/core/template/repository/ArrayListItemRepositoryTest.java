package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ArrayListItemRepositoryTest {
    private ArrayListItemRepository arrayListItemRepository;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoryConfiguration.class);
        arrayListItemRepository = context.getBean("arrayListItemRepository", ArrayListItemRepository.class);
        item1 = new Item(1, "Стол", 9990.0, "Brown");
        item2 = new Item(2, "Стул", 3990.0, "Black");
    }

    @Test
    public void getByIdTest() {
        arrayListItemRepository.holder.add(item1);
        arrayListItemRepository.holder.add(item2);
        assertEquals(item2 ,arrayListItemRepository.getById(item2.getId()));
    }

    @Test
    public void getByNotExistingIdTest() {
        arrayListItemRepository.holder.add(item1);
        arrayListItemRepository.holder.add(item2);
        assertNull(arrayListItemRepository.getById(5));
    }

    @Test
    public void createItemTest() {
        arrayListItemRepository.createItem(item1);
        arrayListItemRepository.createItem(item2);
        assertEquals(item1, arrayListItemRepository.holder.get(0));
        assertEquals(item2, arrayListItemRepository.holder.get(1));
    }

    @Test
    public void createNullItemTest() {
        arrayListItemRepository.createItem(null);
        assertTrue(arrayListItemRepository.holder.isEmpty());
    }

    @Test
    public void createExistingItemTest() {
        int size;
        arrayListItemRepository.holder.add(item1);
        size = arrayListItemRepository.holder.size();
        arrayListItemRepository.createItem(item1);
        assertEquals(size, arrayListItemRepository.holder.size());
    }

    @Test
    public void setInitialSequenceTest() {
        arrayListItemRepository.setInitialSequence(arrayListItemRepository.getValueForInitialSequence());
        assertEquals(14, arrayListItemRepository.initialSequence);
    }
}