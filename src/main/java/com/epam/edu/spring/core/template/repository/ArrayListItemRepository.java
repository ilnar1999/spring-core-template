package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Value("${initial.sequence}")
    private int valueForInitialSequence;

    public int getValueForInitialSequence() {
        return valueForInitialSequence;
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
        holder = new ArrayList<>();
    }
}
