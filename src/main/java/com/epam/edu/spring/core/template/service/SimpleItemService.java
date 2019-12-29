package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Lazy
@Component
public class SimpleItemService implements ItemService {
    private ApplicationContext repositoryContext = new AnnotationConfigApplicationContext(RepositoryConfiguration.class);

    @Value("${item.repository.implementation}")
    private String repositoryImplementation;
    private ItemRepository itemRepository;

    public String getRepositoryImplementation() {
        return repositoryImplementation;
    }

    public ApplicationContext getRepositoryContext() {
        return repositoryContext;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @PostConstruct
    void setItemRepository() {
        if (repositoryImplementation.equalsIgnoreCase("linked")) {
            itemRepository = repositoryContext.getBean("linkedListItemRepository", LinkedListItemRepository.class);
        } else {
            itemRepository = repositoryContext.getBean("arrayListItemRepository", ArrayListItemRepository.class);
        }
    }
}
