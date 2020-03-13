package fr.myschool.productmanager.dao;

import java.util.List;

import fr.myschool.productmanager.entity.Category;

public interface CategoryDao {

	Category findCategoryById(Long id);

	List<Category> getAllCategories();
}
