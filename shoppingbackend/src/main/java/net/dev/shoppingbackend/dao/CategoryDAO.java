package net.dev.shoppingbackend.dao;

import java.util.List;

import net.dev.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);
 
	
}
