package net.dev.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.dev.shoppingbackend.dao.CategoryDAO;
import net.dev.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("Cat_1.png");

		categories.add(category);

		category = new Category();

		// adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageURL("Cat_2.png");

		categories.add(category);

		category = new Category();

		// adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("Cat_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		// enhanced for loop
		for (Category category : categories) {

			if (category.getId() == id)
				return category;
		}
		return null;
	}

}
