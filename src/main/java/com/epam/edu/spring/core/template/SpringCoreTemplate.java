package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.initialization.Initializer;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		SimpleItemService simpleItemService = context.getBean("simpleItemService", SimpleItemService.class);
		Initializer initializer = context.getBean("initializer", Initializer.class);
		ColorFactory colorFactory = context.getBean("colorFactory", ColorFactory.class);
		ArrayListItemRepository arrayListItemRepository = context.getBean("arrayListItemRepository",
																			  ArrayListItemRepository.class);
		LinkedListItemRepository linkedListItemRepository = context.getBean("linkedListItemRepository",
																				LinkedListItemRepository.class);

		initializer.createItems(simpleItemService);
		simpleItemService.createItem(new Item(15, "Карандаш", 20, "Gray"));
		System.out.println(simpleItemService.getById(3).getPrice());
		System.out.println(simpleItemService.getById(15).getColor());
		System.out.println(colorFactory.getColorsList());
		System.out.println(arrayListItemRepository.getValueForInitialSequence());
		System.out.println(linkedListItemRepository.getRandomValue());
	}
}
