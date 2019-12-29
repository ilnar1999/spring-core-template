package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Component
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {
    @InjectRandomInt(min = 1, max = 100)
    private int randomValue;

    public int getRandomValue() {
        return randomValue;
    }

    @Override
    public Item getById(long id) {
        if (!holder.isEmpty()) {
            for (Item item: holder) {
                if (id == item.getId()) {
                    return item;
                }
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if (item != null) {
            if (!holder.isEmpty()) {
                for (Item itemFromHolder: holder) {
                    if (itemFromHolder.getId() == item.getId()) {
                        return false;
                    }
                }
            }
            holder.add(item);
            return true;
        }
        return false;
    }

    void setInitialSequence(int val) {
        initialSequence = val;
    }

    @PostConstruct
    void setHolder() {
        holder = new LinkedList<>();
    }
}
